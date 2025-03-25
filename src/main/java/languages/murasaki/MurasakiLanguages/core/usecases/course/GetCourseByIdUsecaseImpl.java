package languages.murasaki.MurasakiLanguages.core.usecases.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;

public class GetCourseByIdUsecaseImpl implements GetCourseByIdUsecase{

    public final CourseGateway courseGateway;

    public GetCourseByIdUsecaseImpl(CourseGateway courseGateway) {
        this.courseGateway = courseGateway;
    }

    @Override
    public Course execute(String id) {
        return courseGateway.getCourseById(id);
    }
}
