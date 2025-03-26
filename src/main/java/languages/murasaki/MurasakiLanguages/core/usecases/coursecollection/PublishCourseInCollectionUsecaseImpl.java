package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class PublishCourseInCollectionUsecaseImpl implements PublishCourseInCollectionUsecase {

    public final CourseCollectionGateway courseCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public PublishCourseInCollectionUsecaseImpl(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseCollectionGateway = courseCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public String execute(String collectionId, String courseId, boolean status) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

       return courseCollectionGateway.publishCourseInCollection(collectionId, courseId, status);
    }
}
