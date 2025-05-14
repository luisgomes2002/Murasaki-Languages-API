package languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson;

import languages.murasaki.MurasakiLanguages.core.gateway.CompletedLessonGateway;

public class RemoveLessonUsecaseImpl implements RemoveLessonUsecase{

    private final CompletedLessonGateway completedLessonGateway;

    public RemoveLessonUsecaseImpl(CompletedLessonGateway completedLessonGateway) {
        this.completedLessonGateway = completedLessonGateway;
    }

    @Override
    public void execute(String userId, String lessonId) {
        completedLessonGateway.removeLesson(userId, lessonId);
    }
}
