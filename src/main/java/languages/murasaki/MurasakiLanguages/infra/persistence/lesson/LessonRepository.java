package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends MongoRepository<LessonEntity, String> {


}
