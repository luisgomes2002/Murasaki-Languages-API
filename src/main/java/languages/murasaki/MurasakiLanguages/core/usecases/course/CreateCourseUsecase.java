package languages.murasaki.MurasakiLanguages.core.usecases.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;

public interface CreateCourseUsecase {

    public Course execute(String collectionId, Course course);
}
