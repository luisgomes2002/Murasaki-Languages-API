package languages.murasaki.MurasakiLanguages.core.usecases.course.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;

public interface GetCourseByIdUsecase {

    Course execute(String id);
}
