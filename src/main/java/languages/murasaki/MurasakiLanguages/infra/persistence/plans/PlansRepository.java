package languages.murasaki.MurasakiLanguages.infra.persistence.plans;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlansRepository extends MongoRepository<PlansEntity, String> {
}
