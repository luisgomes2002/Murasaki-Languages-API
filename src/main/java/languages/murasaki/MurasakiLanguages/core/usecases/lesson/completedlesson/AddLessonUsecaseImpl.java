package languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson;

import languages.murasaki.MurasakiLanguages.core.gateway.CompletedLessonGateway;

public class AddLessonUsecaseImpl implements AddLessonUsecase{

    private final CompletedLessonGateway completedLessonGateway;

    public AddLessonUsecaseImpl(CompletedLessonGateway completedLessonGateway) {
        this.completedLessonGateway = completedLessonGateway;
    }

    @Override
    public void execute(String userId, String lessonId) {
        completedLessonGateway.addLesson(userId, lessonId);
    }
}
