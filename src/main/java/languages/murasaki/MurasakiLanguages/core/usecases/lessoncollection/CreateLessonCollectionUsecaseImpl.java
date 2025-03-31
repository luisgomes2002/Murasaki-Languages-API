package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessonCollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class CreateLessonCollectionUsecaseImpl implements CreateLessonCollectionUsecase {

    private final LessonCollectionGateway lessonCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public CreateLessonCollectionUsecaseImpl(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonCollectionGateway = lessonCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public lessonCollection execute(lessonCollection lessonCollection) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(lessonCollection.languageName() == null){
            throw new MissingArgumentsException("Campo faltando");
        }

        return lessonCollectionGateway.createLessonCollection(lessonCollection);
    }
}
