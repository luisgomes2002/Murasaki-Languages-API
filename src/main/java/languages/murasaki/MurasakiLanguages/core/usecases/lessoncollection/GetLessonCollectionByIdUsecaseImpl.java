package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetLessonCollectionByIdUsecaseImpl implements GetLessonCollectionByIdUsecase {

    private final LessonCollectionGateway lessonCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetLessonCollectionByIdUsecaseImpl(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonCollectionGateway = lessonCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public lessonCollection execute(String collectionId) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return lessonCollectionGateway.getLessonCollectionById(collectionId);
    }
}
