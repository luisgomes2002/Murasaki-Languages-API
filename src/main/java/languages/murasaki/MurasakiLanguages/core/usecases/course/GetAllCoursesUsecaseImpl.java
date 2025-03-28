package languages.murasaki.MurasakiLanguages.core.usecases.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllCoursesUsecaseImpl implements GetAllCoursesUsecase {

    private final CourseGateway courseGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllCoursesUsecaseImpl(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseGateway = courseGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<Course> execute() {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return courseGateway.getAllCourses();
    }
}
