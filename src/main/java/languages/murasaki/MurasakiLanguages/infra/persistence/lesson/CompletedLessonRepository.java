package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompletedLessonRepository extends MongoRepository<CompletedLessonEntity, String> {

    Optional<CompletedLessonEntity> findCompletedLessonByUserId(String userId);
}
