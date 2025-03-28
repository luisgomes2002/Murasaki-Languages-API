package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.course.CourseEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.CourseEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.CourseRepository;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CourseRepositoryGateway implements CourseGateway {
    private static final Logger log = LoggerFactory.getLogger(CourseRepositoryGateway.class);
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

        CourseEntity savedCourse = courseRepository.save(entity);

        return courseEntityMapper.toDomain(savedCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll().stream().map(courseEntityMapper::toDomain).toList();
    }

    @Override
    @Cacheable(value = "course", key = "#id")
    public Course getCourseById(String id) {
        return courseRepository.findById(id).map(courseEntityMapper::toDomain).orElse(null);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        return null;
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public boolean publishCourse(String courseId) {
        Course course = getCourseById(courseId);

        CourseEntity entity = courseEntityMapper.toEntity(course);

        if(course.published()){
            entity.setPublished(false);
            courseRepository.save(entity);
            return false;
        }

        entity.setPublished(true);
        courseRepository.save(entity);
        return true;
    }

    @Override
    public boolean courseIdExists(String id) {
        return courseRepository.existsById(id);
    }

}
