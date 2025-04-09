package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkSheetsRepository extends MongoRepository<WorksheetsEntity, String> {
}
