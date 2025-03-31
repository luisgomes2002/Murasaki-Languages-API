package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllLessonUsecaseImpl implements GetAllLessonUsecase {

    private final LessonGateway lessonGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllLessonUsecaseImpl(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonGateway = lessonGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<Lesson> execute() {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return lessonGateway.getAllLessons();
    }
}
