package languages.murasaki.MurasakiLanguages.core.usecases.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetCourseByIdUsecaseImpl implements GetCourseByIdUsecase{

    public final CourseGateway courseGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetCourseByIdUsecaseImpl(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseGateway = courseGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Course execute(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!courseGateway.courseIdExists(id)) throw new IdNotFoundException("Course não encontrado");

        return courseGateway.getCourseById(id);
    }
}
