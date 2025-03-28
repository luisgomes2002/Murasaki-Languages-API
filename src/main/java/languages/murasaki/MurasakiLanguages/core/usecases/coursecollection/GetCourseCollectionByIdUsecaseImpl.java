package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetCourseCollectionByIdUsecaseImpl implements GetCourseCollectionByIdUsecase {

    private final CourseCollectionGateway courseCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetCourseCollectionByIdUsecaseImpl(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseCollectionGateway = courseCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public CourseCollection execute(String collectionId) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return courseCollectionGateway.getCourseCollectionById(collectionId);
    }
}
