package languages.murasaki.MurasakiLanguages.core.usecases.course.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class CreateCourseUsecaseImpl implements CreateCourseUsecase{

    private final CourseGateway courseGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public CreateCourseUsecaseImpl(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.courseGateway = courseGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Course execute(Course course) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(course.title() == null || course.text() == null || course.languageType() == null || course.japaneseLevels() == null || course.explanations() == null || course.links() == null)
            throw new MissingArgumentsException("Campos faltando");


        return courseGateway.createCourse(course);
    }
}
