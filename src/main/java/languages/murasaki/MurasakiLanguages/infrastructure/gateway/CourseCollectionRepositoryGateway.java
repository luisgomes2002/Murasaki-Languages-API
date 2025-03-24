package languages.murasaki.MurasakiLanguages.infrastructure.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.infrastructure.mapper.courseCollection.CourseCollectionEntityMapper;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.courseCollection.CourseCollectionEntity;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.courseCollection.CourseCollectionRepository;
import org.springframework.stereotype.Component;

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
}
