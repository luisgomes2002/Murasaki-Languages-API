package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.userreport.UserReportEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportRepository;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Configuration
public class UserReportRepositoryGateway implements UserReportGateway {

    private final UserReportRepository userReportRepository;
    private final UserReportEntityMapper userReportEntityMapper;

    public UserReportRepositoryGateway(UserReportRepository userReportRepository, UserReportEntityMapper userReportEntityMapper) {
        this.userReportRepository = userReportRepository;
        this.userReportEntityMapper = userReportEntityMapper;
    }

    @Override
    public void createUserReport(String name, String userId, UserReportDetail detail) {
        Optional<UserReportEntity> existReport = userReportRepository.findUserReportByName(name);

        if(existReport.isPresent()){
            UserReportEntity newReport = existReport.get();

            boolean alreadyExists = newReport.getReports().stream()
                    .anyMatch(r -> r.questionId().equals(detail.questionId()));

            if (!alreadyExists) {
                newReport.getReports().add(detail);
                newReport.setUpdatedAt(LocalDateTime.now());

                userReportRepository.save(newReport);
            }
        }else{
            UserReportEntity entity = new UserReportEntity();

            entity.setUserId(userId);
            entity.setName(name);
            entity.setReports(new ArrayList<>());
            entity.getReports().add(detail);
            entity.setUpdatedAt(LocalDateTime.now());

            userReportRepository.save(entity);
        }
    }

    @Override
    public void removeUserReport(String name, String questionId) {
        Optional<UserReportEntity> existReport = userReportRepository.findUserReportByName(name);

        if (existReport.isPresent()) {
            UserReportEntity report = existReport.get();

            boolean removed = report.getReports().removeIf(r -> r.questionId().equals(questionId));

            if (removed) {
                report.setUpdatedAt(LocalDateTime.now());
                userReportRepository.save(report);
            }
        }
    }

    @Override
    public UserReport getReportById(String reportId) {
        Optional<UserReportEntity> userReport = userReportRepository.findById(reportId);

        return userReportEntityMapper.toDomain(userReport.orElse(null));

    }
}
