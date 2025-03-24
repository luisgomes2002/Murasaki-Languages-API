package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;

import java.util.List;

public interface CourseGateway {

    Course createCourse(String collectionId, Course course);
    List<Course> getAllCourse();
    Course getCourseById(String id);
    Course updateCourse(String id, Course course);

    void deleteCourse(String id);


}
