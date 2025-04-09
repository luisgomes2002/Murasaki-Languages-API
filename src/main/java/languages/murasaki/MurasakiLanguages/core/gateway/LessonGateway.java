package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;

import java.util.List;

public interface LessonGateway {

    Lesson createLesson(Lesson lesson);
    List<Lesson> getAllLessons();
    Lesson getLessonById(String id);
    Lesson updateLesson(String id, Lesson lesson);

    void deleteLesson(String id);

    boolean publishLesson(String lessonId);
    boolean lessonIdExists(String id);
}
