package languages.murasaki.MurasakiLanguages.infra.persistence.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AiReportRepository extends MongoRepository<AiReportEntity, String> {

    List<AiReport> findAiReportByUserId(String userId);
}
