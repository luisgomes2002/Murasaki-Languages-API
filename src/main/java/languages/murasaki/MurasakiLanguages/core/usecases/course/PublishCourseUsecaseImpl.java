package languages.murasaki.MurasakiLanguages.core.usecases.course;

import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;

public class PublishCourseUsecaseImpl implements PublishCourseUsecase{

    private final CourseGateway courseGateway;

    public PublishCourseUsecaseImpl(CourseGateway courseGateway) {
        this.courseGateway = courseGateway;
    }

    @Override
    public String execute(String courseId) {
        return courseGateway.publishCourse(courseId);
    }
}
