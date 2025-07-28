package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;
import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;

import java.util.List;

public interface LessonGateway {

    Lesson createLesson(Lesson lesson);
    Pagination<Lesson> getAllLessons(int page, int size);
    Lesson getLessonById(String id);
    Lesson updateLesson(String id, Lesson lesson);
    Pagination<Lesson> getLessonsByVisibility(Visibility visibility, int page, int size);
    List<Lesson> getLessonsByPublishedOrNot(boolean published, int page, int size);
    Pagination<Lesson> getPublicLessons(int page, int size);
    List<Lesson> getLessonsByPublishedTrue(int page, int size);
    Pagination<Lesson> getJapaneseLessonsByLevelPublic(LanguagesLevels levels, int page, int size);
    Pagination<Lesson> getJapaneseLessonsByLevel(LanguagesLevels level, int page, int size);
    List<Lesson> getJapanesePublicLessons(int page, int size);
    Pagination<Lesson> getAllJapaneseLessons(int page, int size);

    void deleteLesson(String id);
    void addExplanation(String lessonId, String explanationId);
    void addWorksheets(String lessonId, String worksheetId);
    void removeExplanation(String lessonId, String explanationId);
    void removeWorksheets(String lessonId, String worksheetId);
    void ChangeVisibility(String lessonId, Visibility visibility);

    boolean publishLesson(String lessonId);
    boolean lessonIdExists(String id);
}
