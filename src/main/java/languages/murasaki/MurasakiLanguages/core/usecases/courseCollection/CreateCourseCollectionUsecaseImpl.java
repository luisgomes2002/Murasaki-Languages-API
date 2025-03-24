package languages.murasaki.MurasakiLanguages.core.usecases.courseCollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infrastructure.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infrastructure.exceptions.UserDoesNotHavePermissionException;

public class CreateCourseCollectionUsecaseImpl implements CreateCourseCollectionUsecase{

    private final CourseCollectionGateway courseCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public CreateCourseCollectionUsecaseImpl(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseCollectionGateway = courseCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public CourseCollection execute(CourseCollection courseCollection) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(courseCollection.languageName() == null){
            throw new MissingArgumentsException("Campo faltando");
        }

        return courseCollectionGateway.createCourseCollection(courseCollection);
    }
}
