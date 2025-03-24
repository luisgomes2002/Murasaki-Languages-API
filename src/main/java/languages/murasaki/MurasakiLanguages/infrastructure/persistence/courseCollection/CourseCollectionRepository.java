package languages.murasaki.MurasakiLanguages.infrastructure.persistence.courseCollection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCollectionRepository  extends MongoRepository<CourseCollectionEntity, String> {
}
