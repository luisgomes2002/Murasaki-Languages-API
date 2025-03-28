package languages.murasaki.MurasakiLanguages.core.usecases.course.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;

public interface CreateCourseUsecase {

    public Course execute(Course course);
}
