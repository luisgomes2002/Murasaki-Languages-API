package languages.murasaki.MurasakiLanguages.infrastructure.persistence.course;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<CourseEntity, String> {


}
