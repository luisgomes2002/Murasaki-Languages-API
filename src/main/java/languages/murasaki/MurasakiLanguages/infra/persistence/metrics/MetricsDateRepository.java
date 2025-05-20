package languages.murasaki.MurasakiLanguages.infra.persistence.metrics;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetricsDateRepository extends MongoRepository<MetricsDateEntity, String> {
}
