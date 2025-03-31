package languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonCollectionRepository extends MongoRepository<LessonsCollectionEntity, String> {
}
