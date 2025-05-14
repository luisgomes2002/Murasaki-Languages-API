package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;
import languages.murasaki.MurasakiLanguages.core.gateway.CompletedLessonGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.CompletedLessonEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.CompletedLessonEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.CompletedLessonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompletedLessonRepositoryGateway implements CompletedLessonGateway {

    private final CompletedLessonRepository completedLessonRepository;
    private final CompletedLessonEntityMapper completedLessonEntityMapper;

    public CompletedLessonRepositoryGateway(CompletedLessonRepository completedLessonRepository, CompletedLessonEntityMapper completedLessonEntityMapper) {
        this.completedLessonRepository = completedLessonRepository;
        this.completedLessonEntityMapper = completedLessonEntityMapper;
    }

    @Override
    public void addLesson(String userId, String lessonId) {
        Optional<CompletedLessonEntity> entity = completedLessonRepository.findCompletedLessonByUserId(userId);

        if(entity.isPresent()){
            CompletedLessonEntity newCompletedLesson = entity.get();

            boolean alreadyExists = newCompletedLesson.getCompletedLesson().stream()
                    .anyMatch(l -> l.equals(lessonId));

            if(!alreadyExists){
                newCompletedLesson.getCompletedLesson().add(lessonId);

                completedLessonRepository.save(newCompletedLesson);
            }
        }else {
            CompletedLessonEntity completedLesson = new CompletedLessonEntity();

            completedLesson.getCompletedLesson().add(lessonId);

            completedLessonRepository.save(completedLesson);
        }
    }

    @Override
    public void removeLesson(String userId, String lessonId) {
        Optional<CompletedLessonEntity> entity = completedLessonRepository.findCompletedLessonByUserId(userId);

        if(entity.isPresent()){
            CompletedLessonEntity lesson = entity.get();

            boolean remove = lesson.getCompletedLesson().removeIf(l -> l.equals(lessonId));

            if(remove){
                completedLessonRepository.save(lesson);
            }
        }
    }

    @Override
    public List<CompletedLesson> getAllCompletedLessons() {
        return completedLessonRepository.findAll().stream().map(completedLessonEntityMapper::toDomain).toList();
    }
}