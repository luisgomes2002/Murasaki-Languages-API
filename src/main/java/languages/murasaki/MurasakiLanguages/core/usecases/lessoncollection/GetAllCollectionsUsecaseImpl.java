package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessonCollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllCollectionsUsecaseImpl implements GetAllCollectionsUsecase{

    private final LessonCollectionGateway lessonCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllCollectionsUsecaseImpl(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonCollectionGateway = lessonCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<lessonCollection> execute() {
        UserInfo userInfo= authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return lessonCollectionGateway.getAllCollections();
    }
}
