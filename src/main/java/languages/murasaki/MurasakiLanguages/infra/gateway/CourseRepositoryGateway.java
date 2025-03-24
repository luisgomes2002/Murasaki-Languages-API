package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.course.Course;
import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.GetCourseCollectionByIdUsecase;
import languages.murasaki.MurasakiLanguages.infra.mapper.course.CourseEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.mapper.coursecollection.CourseCollectionEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.CourseEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.CourseRepository;
import languages.murasaki.MurasakiLanguages.infra.persistence.coursecollection.CourseCollectionEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.coursecollection.CourseCollectionRepository;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserInfoEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CourseRepositoryGateway implements CourseGateway {

    private final CourseRepository courseRepository;
    private final CourseCollectionRepository courseCollectionRepository;
    private final CourseEntityMapper courseEntityMapper;
    private final GetCourseCollectionByIdUsecase getCourseCollectionByIdUsecase;
    private final CourseCollectionEntityMapper courseCollectionEntityMapper;

    public CourseRepositoryGateway(CourseRepository courseRepository, CourseCollectionRepository courseCollectionRepository, CourseEntityMapper courseEntityMapper, GetCourseCollectionByIdUsecase getCourseCollectionByIdUsecase, CourseCollectionEntityMapper courseCollectionEntityMapper) {
        this.courseRepository = courseRepository;
        this.courseCollectionRepository = courseCollectionRepository;
        this.courseEntityMapper = courseEntityMapper;
        this.getCourseCollectionByIdUsecase = getCourseCollectionByIdUsecase;
        this.courseCollectionEntityMapper = courseCollectionEntityMapper;
    }

    @Override
    public Course createCourse(String collectionId, Course course) {
        UserInfoEntity principal = (UserInfoEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CourseEntity entity = courseEntityMapper.toEntity(course);
        entity.setUsername(principal.getUsername());
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        CourseEntity savedCourse = courseRepository.save(entity);

        CourseCollection courseCollection = getCourseCollectionByIdUsecase.execute(collectionId);
        courseCollection.coursesId().add(savedCourse.getId());

        CourseCollectionEntity courseCollectionEntity = courseCollectionEntityMapper.toEntity(courseCollection);
        courseCollectionRepository.save(courseCollectionEntity);

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
