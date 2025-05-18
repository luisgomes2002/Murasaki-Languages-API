package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class ChangeVisibilityUsecaseImpl implements ChangeVisibilityUsecase{

    private final LessonGateway lessonGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public ChangeVisibilityUsecaseImpl(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonGateway = lessonGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String lessonId, Visibility visibility) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!lessonGateway.lessonIdExists(lessonId)) throw new IdNotFoundException("Aula não encontrado");

        lessonGateway.ChangeVisibility(lessonId, visibility);
    }
}
