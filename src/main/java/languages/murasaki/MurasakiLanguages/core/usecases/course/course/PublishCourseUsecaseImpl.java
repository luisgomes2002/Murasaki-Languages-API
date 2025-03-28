package languages.murasaki.MurasakiLanguages.core.usecases.course.course;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class PublishCourseUsecaseImpl implements PublishCourseUsecase{

    private final CourseGateway courseGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public PublishCourseUsecaseImpl(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseGateway = courseGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public boolean execute(String courseId) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!courseGateway.courseIdExists(courseId)) throw new IdNotFoundException("Course não encontrado");

        return courseGateway.publishCourse(courseId);
    }
}
