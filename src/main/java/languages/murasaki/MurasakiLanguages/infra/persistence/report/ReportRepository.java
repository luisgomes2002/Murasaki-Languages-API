package languages.murasaki.MurasakiLanguages.infra.persistence.report;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<ReportEntity, String> {
}
