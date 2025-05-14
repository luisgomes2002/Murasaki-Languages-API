package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.CompletedLesson;

import java.util.List;

public interface CompletedLessonGateway {

    List<CompletedLesson> getAllCompletedLessons();

    void addLesson(String userId, String lessonId);
    void removeLesson(String userId, String lessonId);
}
