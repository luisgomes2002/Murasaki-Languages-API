package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetLessonByIdUsecaseImpl implements GetLessonByIdUsecase {

    private final LessonGateway lessonGateway;

    public GetLessonByIdUsecaseImpl(LessonGateway lessonGateway) {
        this.lessonGateway = lessonGateway;
    }

    @Override
    public Lesson execute(String id) {


        if(!lessonGateway.lessonIdExists(id)) throw new IdNotFoundException("Aula não encontrado");

        return lessonGateway.getLessonById(id);
    }
}
