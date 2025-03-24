package languages.murasaki.MurasakiLanguages.infrastructure.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.infrastructure.dtos.user.UserInfoDto;
import languages.murasaki.MurasakiLanguages.infrastructure.mapper.course.CourseEntityMapper;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.course.CourseEntity;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.course.CourseRepository;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.user.UserInfoEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CourseRepositoryGateway implements CourseGateway {

    private final CourseRepository courseRepository;
    private final CourseEntityMapper courseEntityMapper;

    public CourseRepositoryGateway(CourseRepository courseRepository, CourseEntityMapper courseEntityMapper) {
        this.courseRepository = courseRepository;
        this.courseEntityMapper = courseEntityMapper;
    }

    @Override
    public Course createCourse(Course course) {
        UserInfoEntity principal = (UserInfoEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CourseEntity entity = courseEntityMapper.toEntity(course);
        entity.setUsername(principal.getUsername());
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        courseRepository.save(entity);
        return courseEntityMapper.toDomain(entity);
    }

    @Override
    public List<Course> getAllCourse() {
        return List.of();
    }

    @Override
    public Course getCourseById(String id) {
        return null;
    }

    @Override
    public Course updateCourse(String id, Course course) {
        return null;
    }

    @Override
    public void deleteCourse(String id) {

    }
}
