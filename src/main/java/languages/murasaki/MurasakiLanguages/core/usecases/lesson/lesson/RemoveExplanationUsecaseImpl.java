package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class RemoveExplanationUsecaseImpl implements RemoveExplanationUsecase {

    private final LessonGateway lessonGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public RemoveExplanationUsecaseImpl(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonGateway = lessonGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String lessonId, String explanationId) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        lessonGateway.removeExplanation(lessonId, explanationId);
    }
}
