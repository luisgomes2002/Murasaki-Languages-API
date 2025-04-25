package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateLessonUsecaseImpl implements UpdateLessonUsecase{

    private final LessonGateway lessonGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateLessonUsecaseImpl(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonGateway = lessonGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Lesson execute(String id, Lesson lesson) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!lessonGateway.lessonIdExists(id)) throw new IdNotFoundException("Aula não encontrado");

        return lessonGateway.updateLesson(id, lesson);
    }
}
