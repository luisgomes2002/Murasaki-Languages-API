package languages.murasaki.MurasakiLanguages.infra.persistence.aireport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AiReportRepository extends MongoRepository<AiReportEntity, String> {

    Page<AiReportEntity> findByUserId(String userId, Pageable pageable);
}
