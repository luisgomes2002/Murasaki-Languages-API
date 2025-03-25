package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.coursecollection.CourseCollectionEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.coursecollection.CourseCollectionEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.coursecollection.CourseCollectionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseCollectionRepositoryGateway implements CourseCollectionGateway {

    private final CourseCollectionRepository courseCollectionRepository;
    private final CourseCollectionEntityMapper courseCollectionEntityMapper;

    public CourseCollectionRepositoryGateway(CourseCollectionRepository courseCollectionRepository, CourseCollectionEntityMapper courseCollectionEntityMapper) {
        this.courseCollectionRepository = courseCollectionRepository;
        this.courseCollectionEntityMapper = courseCollectionEntityMapper;
    }

    @Override
    public CourseCollection createCourseCollection(CourseCollection courseCollection) {
        CourseCollectionEntity entity = courseCollectionEntityMapper.toEntity(courseCollection);
        courseCollectionRepository.save(entity);
        return courseCollectionEntityMapper.toDomain(entity);
    }

    @Override
    public List<CourseCollection> getAllCollections() {
        return courseCollectionRepository.findAll().stream().map(courseCollectionEntityMapper::toDomain).toList();
    }

    @Override
    public CourseCollection getCourseCollectionById(String collectionId) {
        return courseCollectionRepository.findById(collectionId).map(courseCollectionEntityMapper::toDomain).orElse(null);
    }

    @Override
    public void publishCourseInCollection(String collectionId, String courseId) {
        CourseCollection courseCollection = getCourseCollectionById(collectionId);
        courseCollection.coursesId().add(courseId);

        CourseCollectionEntity courseCollectionEntity = courseCollectionEntityMapper.toEntity(courseCollection);
        courseCollectionRepository.save(courseCollectionEntity);
    }
}
