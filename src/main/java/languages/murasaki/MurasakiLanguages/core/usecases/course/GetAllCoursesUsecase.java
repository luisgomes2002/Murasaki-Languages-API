package languages.murasaki.MurasakiLanguages.core.usecases.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;

import java.util.List;

public interface GetAllCoursesUsecase {

    List<Course> execute();
}
