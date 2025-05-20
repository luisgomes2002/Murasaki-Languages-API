package languages.murasaki.MurasakiLanguages.infra.persistence.metrics;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetricsRepository extends MongoRepository<MetricsEntity, String> {
}
