package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserAnswersLogRepository extends MongoRepository<UserAnswersLogEntity, String> {

    Optional<UserAnswersLogEntity> findUserAnswersLogByUserId(String userId);
}
