package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.LessonEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.LessonEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.LessonRepository;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserInfoEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class LessonRepositoryGateway implements LessonGateway {

    private final LessonRepository lessonRepository;
    private final LessonEntityMapper lessonEntityMapper;

    public LessonRepositoryGateway(LessonRepository lessonRepository, LessonEntityMapper lessonEntityMapper) {
        this.lessonRepository = lessonRepository;
        this.lessonEntityMapper = lessonEntityMapper;
    }

    @Override
    public Lesson createLesson(Lesson lesson) {
        UserInfoEntity principal = (UserInfoEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        LessonEntity entity = lessonEntityMapper.toEntity(lesson);
        entity.setName(principal.getName());
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setVisibility(Visibility.valueOf("PRIVATE"));

        lessonRepository.save(entity);

        return lessonEntityMapper.toDomain(entity);
    }

    @Override
    @Cacheable(value = "all-lessons")
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll().stream().map(lessonEntityMapper::toDomain).toList();
    }

    @Override
    @Cacheable(value = "lesson", key = "#id")
    public Lesson getLessonById(String id) {
        return lessonRepository.findById(id).map(lessonEntityMapper::toDomain).orElse(null);
    }

    @Override
    @Cacheable(value = "lesson-by-published-or-not")
    public List<Lesson> getLessonsByPublishedOrNot(boolean published) {
        return lessonRepository.findByPublished(published)
                .stream()
                .map(lessonEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Cacheable(value = "lesson-by-published")
    public List<Lesson> getLessonsByPublishedTrue() {
        return lessonRepository.findByPublished(true)
                .stream()
                .map(lessonEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Cacheable(value = "lesson-by-visibility")
    public List<Lesson> getLessonsByVisibility(Visibility visibility) {
        return lessonRepository.findByVisibility(visibility)
                .stream()
                .map(lessonEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Cacheable(value = "lesson-public")
    public List<Lesson> getPublicLessons() {
        return lessonRepository.findByVisibility(Visibility.PUBLIC)
                .stream()
                .map(lessonEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Cacheable(value = "lesson-japanese-by-level")
    public List<Lesson> getJapanesLessonsByLevel(JapaneseLevels level) {
        return lessonRepository
                .findByJapaneseLevelsAndPublishedTrueAndVisibility(level, Visibility.PUBLIC)
                .stream()
                .map(lessonEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void ChangeVisibility(String lessonId, Visibility visibility) {
        Optional<LessonEntity> entity = lessonRepository.findById(lessonId);

        if(entity.isPresent()){
            LessonEntity newLesson = entity.get();

            newLesson.setVisibility(visibility);

            lessonRepository.save(newLesson);
        }
    }

    @Override
    public Lesson updateLesson(String id, Lesson lesson) {
        Optional<LessonEntity> entity = lessonRepository.findById(id);

        if(entity.isPresent()){
            LessonEntity updatedLesson = entity.get();

            updatedLesson.setTitle(lesson.title());
            updatedLesson.setText(lesson.text());
            updatedLesson.setLinks(lesson.links());
            updatedLesson.setLanguageType(lesson.languageType());
            updatedLesson.setJapaneseLevels(lesson.japaneseLevels());
            updatedLesson.setPublished(lesson.published());
            updatedLesson.setVisibility(lesson.visibility());
            updatedLesson.setUpdatedAt(LocalDateTime.now());

            lessonRepository.save(updatedLesson);

            return lessonEntityMapper.toDomain(updatedLesson);
        }
            return null;
    }

    @Override
    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public boolean publishLesson(String lessonId) {
        Lesson lesson = getLessonById(lessonId);

        LessonEntity entity = lessonEntityMapper.toEntity(lesson);

        if(lesson.published()){
            entity.setPublished(false);
            lessonRepository.save(entity);
            return false;
        }

        entity.setPublished(true);
        lessonRepository.save(entity);
        return true;
    }

    @Override
    public boolean lessonIdExists(String id) {
        return lessonRepository.existsById(id);
    }

    @Override
    public void addExplanation(String lessonId, String explanationId) {
        Optional<LessonEntity> entity = lessonRepository.findById(lessonId);

        if (entity.isPresent()) {
            LessonEntity updatedLesson = entity.get();

            updatedLesson.getExplanations().add(explanationId);

            lessonRepository.save(updatedLesson);
        }
    }

    @Override
    public void addWorksheets(String lessonId, String worksheetId) {
        Optional<LessonEntity> entity = lessonRepository.findById(lessonId);

        if (entity.isPresent()) {
            LessonEntity updatedLesson = entity.get();

            updatedLesson.getWorksheets().add(worksheetId);

            lessonRepository.save(updatedLesson);
        }
    }

    @Override
    public void removeExplanation(String lessonId, String explanationId) {
        Optional<LessonEntity> entity = lessonRepository.findById(lessonId);

        if (entity.isPresent()) {
            LessonEntity updatedLesson = entity.get();

            updatedLesson.getExplanations().remove(explanationId);

            lessonRepository.save(updatedLesson);
        }
    }

    @Override
    public void removeWorksheets(String lessonId, String worksheetId) {
        Optional<LessonEntity> entity = lessonRepository.findById(lessonId);

        if (entity.isPresent()) {
            LessonEntity updatedLesson = entity.get();

            updatedLesson.getWorksheets().remove(worksheetId);

            lessonRepository.save(updatedLesson);
        }
    }
}
