package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllCollectionsUsecaseImpl implements GetAllCollectionsUsecase{

    private final CourseCollectionGateway courseCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllCollectionsUsecaseImpl(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseCollectionGateway = courseCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<CourseCollection> execute() {
        UserInfo userInfo= authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return courseCollectionGateway.getAllCollections();
    }
}
