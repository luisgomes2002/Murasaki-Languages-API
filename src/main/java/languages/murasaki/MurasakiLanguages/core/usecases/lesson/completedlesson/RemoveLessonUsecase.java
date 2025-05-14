package languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson;

public interface RemoveLessonUsecase {

    void execute(String userId, String lessonId);
}
