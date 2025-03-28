package languages.murasaki.MurasakiLanguages.core.usecases.course.course;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class DeleteCourseUsecaseImpl implements DeleteCourseUsecase{

    private final CourseGateway courseGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public DeleteCourseUsecaseImpl(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseGateway = courseGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void deleteCourse(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!courseGateway.courseIdExists(id)) throw new IdNotFoundException("Course não encontrado");

        courseGateway.deleteCourse(id);
    }
}
