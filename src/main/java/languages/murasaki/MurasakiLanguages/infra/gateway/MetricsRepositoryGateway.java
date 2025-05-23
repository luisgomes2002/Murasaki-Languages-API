package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsDate;
import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsUserBirth;
import languages.murasaki.MurasakiLanguages.core.entities.metrics.UsersBirth;
import languages.murasaki.MurasakiLanguages.core.enums.Gender;
import languages.murasaki.MurasakiLanguages.infra.mapper.metrics.MetricsDateEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.mapper.metrics.MetricsEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.metrics.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.domain.Sort;
import languages.murasaki.MurasakiLanguages.core.entities.metrics.Metrics;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

@Component
public class MetricsRepositoryGateway implements MetricsGateway {

    private final MetricsRepository metricsRepository;
    private final MongoTemplate mongoTemplate;
    private final MetricsEntityMapper metricsEntityMapper;
    private final MetricsDateRepository metricsDateRepository;
    private final MetricsDateEntityMapper metricsDateEntityMapper;

    public MetricsRepositoryGateway(MetricsRepository metricsRepository, MongoTemplate mongoTemplate, MetricsEntityMapper metricsEntityMapper, MetricsDateRepository metricsDateRepository, MetricsDateEntityMapper metricsDateEntityMapper) {
        this.metricsRepository = metricsRepository;
        this.mongoTemplate = mongoTemplate;
        this.metricsEntityMapper = metricsEntityMapper;
        this.metricsDateRepository = metricsDateRepository;
        this.metricsDateEntityMapper = metricsDateEntityMapper;
    }

    private static final String FIELD_USER_AGE_DISTRIBUTION = "userAgeDistribution";
    private static final String FIELD_TOP_GENDER = "topGender";
    private static final String FIELD_TOTAL_USERS = "totalUsers";
    private static final String FIELD_ACTIVE_USERS = "activeUsers";
    private static final String FIELD_BANNED_USERS = "bannedUsers";
    private static final String FIELD_DELETED_USERS = "deletedUsers";
    private static final String FIELD_BY_LANGUAGE = "topLanguages";

    @Override
    public Metrics getMetricByDate(String date) {
        LocalDateTime startOfDay = LocalDateTime.parse(date + "T00:00:00");
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        Query query = new Query();
        query.addCriteria(Criteria.where("date").gte(startOfDay).lt(endOfDay));
        query.with(Sort.by(Sort.Direction.ASC, "date")).limit(1);

        MetricsEntity entity = mongoTemplate.findOne(query, MetricsEntity.class);
        return metricsEntityMapper.toDomain(entity);
    }

    private Map<String, Integer> initializeAgeMap() {
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("under18", 0);
        ageMap.put("18-25", 0);
        ageMap.put("25-29", 0);
        ageMap.put("30-39", 0);
        ageMap.put("40plus", 0);
        return ageMap;
    }

    private Map<LanguageType, Integer> initializeLanguageMap() {
        Map<LanguageType, Integer> langMap = new HashMap<>();
        for (LanguageType lang : LanguageType.values()) {
            langMap.put(lang, 0);
        }
        return langMap;
    }

    private Map<Gender, Integer> initializeGenderMap() {
        Map<Gender, Integer> map = new EnumMap<>(Gender.class);
        for (Gender gender : Gender.values()) {
            map.put(gender, 0);
        }
        return map;
    }

    private MetricsEntity createEmptyMetricsEntity() {
        return new MetricsEntity(
                null,
                LocalDateTime.now(),
                0,
                0,
                0,
                0,
                initializeAgeMap(),
                initializeLanguageMap(),
                initializeGenderMap()
        );
    }

    private void updateLatestMetrics(Update update) {
        Optional.ofNullable(getLatestMetricsEntity()).ifPresent(metrics -> {
            Query query = new Query(Criteria.where("_id").is(metrics.getId()));
            mongoTemplate.updateFirst(query, update, MetricsEntity.class);
        });
    }

    private MetricsEntity getLatestMetricsEntity() {
        Query findLatest = new Query().with(Sort.by(Sort.Direction.DESC, "date")).limit(1);
        return mongoTemplate.findOne(findLatest, MetricsEntity.class);
    }

    @Override
    public void metricsCreateUser() {
        MetricsEntity latestMetrics = getLatestMetricsEntity();
        if (latestMetrics != null) {
            Update update = new Update().inc(FIELD_TOTAL_USERS, 1);
            updateLatestMetrics(update);
        } else {
            MetricsEntity newMetrics = createEmptyMetricsEntity();
            newMetrics.setTotalUsers(1);
            metricsRepository.save(newMetrics);
            addMetricsToList(LocalDate.now());
        }
    }

    @Override
    public void metricsActiveUsers(int delta) {
        updateLatestMetrics(new Update().inc(FIELD_ACTIVE_USERS, delta));
    }

    @Override
    public void metricsBanUser(int delta) {
        updateLatestMetrics(new Update().inc(FIELD_BANNED_USERS, delta));
    }

    @Override
    public void metricsDeletedUser() {
        updateLatestMetrics(new Update().inc(FIELD_DELETED_USERS, 1));
    }

    @Override
    public void metricsUpdateUserAge(LocalDate birthDate, String userId) {
        addBirthToList(userId, birthDate.toString());
    }

    @Override
    public void metricsUpdateUserGender(String gender, int delta) {
        updateLatestMetrics(new Update().inc(FIELD_TOP_GENDER + "." + gender, delta));
    }

    private String getAgeGroup(int age) {
        if (age < 18) return "under18";
        else if (age <= 25) return "18-25";
        else if (age <= 29) return "25-29";
        else if (age <= 39) return "30-39";
        else return "40plus";
    }

    @Override
    public void addMetricsToList(LocalDate date) {
        MetricsDateEntity metricsDateEntity = metricsDateRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        if (metricsDateEntity != null) {
            if (!metricsDateEntity.getDateTimes().contains(date)) {
                metricsDateEntity.getDateTimes().add(date);
                metricsDateRepository.save(metricsDateEntity);
            }
        } else {
            MetricsDateEntity newEntity = new MetricsDateEntity();
            newEntity.setDateTimes(new ArrayList<>(List.of(date)));
            metricsDateRepository.save(newEntity);
        }
    }

    @Override
    public List<MetricsDate> getAllMetricsDate() {
        return metricsDateRepository.findAll()
            .stream()
            .map(metricsDateEntityMapper::toDomain)
            .toList();
    }

    @Override
    public void metricsByLanguage(String language, int delta) {
        updateLatestMetrics(new Update().inc( FIELD_BY_LANGUAGE+ "." + language, delta));
    }

    @Override
    public MetricsUserBirth getMetricsUserBirthByDate(String date) {
        return null;
    }

    @Override
    public void addBirthToList(String userId, String birthDate) {
        MetricsUserBirthEntity entity = mongoTemplate.findAll(MetricsUserBirthEntity.class).stream().findFirst().orElse(null);

        if (entity == null) {
            entity = new MetricsUserBirthEntity();
            entity.setDate(LocalDateTime.now());
            entity.setUsersBirths(new ArrayList<>());
        }

        List<UsersBirth> updatedList = new ArrayList<>(entity.getUsersBirths());
        updatedList.removeIf(b -> b.userId().equals(userId));
        updatedList.add(new UsersBirth(userId, birthDate));
        entity.setUsersBirths(updatedList);

        mongoTemplate.save(entity);
    }


    @Override
    public void removeBirthFromList(String userId) {
        MetricsUserBirthEntity entity = mongoTemplate.findAll(MetricsUserBirthEntity.class).stream().findFirst().orElse(null);
        if (entity == null) return;

        entity.getUsersBirths().removeIf(b -> b.userId().equals(userId));
        mongoTemplate.save(entity);
    }

    //@Scheduled(cron = "*/30 * * * * *")
    @Scheduled(cron = "0 0 1 * * *")
    public void processUserBirths() {
        MetricsUserBirthEntity birthEntity = mongoTemplate.findAll(MetricsUserBirthEntity.class).stream().findFirst().orElse(null);
        if (birthEntity == null) return;

        Map<String, Integer> ageMap = initializeAgeMap();
        LocalDate today = LocalDate.now();

        for (UsersBirth user : birthEntity.getUsersBirths()) {
            LocalDate birthDate = LocalDate.parse(user.userBirth());
            int age = Period.between(birthDate, today).getYears();
            String ageGroup = getAgeGroup(age);
            ageMap.put(ageGroup, ageMap.get(ageGroup) + 1);
        }

        Update update = new Update().set(FIELD_USER_AGE_DISTRIBUTION, ageMap);
        updateLatestMetrics(update);
    }

}
