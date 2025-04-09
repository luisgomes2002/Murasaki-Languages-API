package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExplanationRepository extends MongoRepository<ExplanationEntity, String> {
}
