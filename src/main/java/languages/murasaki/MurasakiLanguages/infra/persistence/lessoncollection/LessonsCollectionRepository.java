package languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsCollectionRepository extends MongoRepository<LessonsCollectionEntity, String> {
}
