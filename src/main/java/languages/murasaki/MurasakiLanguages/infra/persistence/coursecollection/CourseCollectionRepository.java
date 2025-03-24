package languages.murasaki.MurasakiLanguages.infra.persistence.coursecollection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCollectionRepository  extends MongoRepository<CourseCollectionEntity, String> {
}
