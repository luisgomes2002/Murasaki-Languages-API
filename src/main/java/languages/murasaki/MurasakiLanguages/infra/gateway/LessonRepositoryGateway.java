package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
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
        entity.setUsername(principal.getUsername());
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setVisibility(Visibility.valueOf("PRIVATE"));

        lessonRepository.save(entity);

        return lessonEntityMapper.toDomain(entity);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll().stream().map(lessonEntityMapper::toDomain).toList();
    }

    @Override
    @Cacheable(value = "lesson", key = "#id")
    public Lesson getLessonById(String id) {
        return lessonRepository.findById(id).map(lessonEntityMapper::toDomain).orElse(null);
    }

    @Override
    public Lesson updateLesson(String id, Lesson lesson) {
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
}
