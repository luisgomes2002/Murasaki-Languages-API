package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

import java.util.List;

public interface LessonGateway {

    Lesson createLesson(Lesson lesson);
    List<Lesson> getAllLessons();
    Lesson getLessonById(String id);
    Lesson updateLesson(String id, Lesson lesson);
    List<Lesson> getLessonsByVisibility(Visibility visibility);
    List<Lesson> getLessonsByPublishedOrNot(boolean published);
    List<Lesson> getPublicLessons();
    List<Lesson> getLessonsByPublishedTrue();

    void deleteLesson(String id);
    void addExplanation(String lessonId, String explanationId);
    void addWorksheets(String lessonId, String worksheetId);
    void removeExplanation(String lessonId, String explanationId);
    void removeWorksheets(String lessonId, String worksheetId);

    boolean publishLesson(String lessonId);
    boolean lessonIdExists(String id);
}
