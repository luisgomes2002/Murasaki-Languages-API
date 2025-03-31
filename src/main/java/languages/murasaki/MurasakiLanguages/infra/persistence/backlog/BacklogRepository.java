package languages.murasaki.MurasakiLanguages.infra.persistence.backlog;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends MongoRepository<BacklogEntity, String> {
}
