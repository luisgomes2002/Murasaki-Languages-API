package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends MongoRepository<LessonEntity, String> {

    // Filtrar por visibility (PUBLIC ou PRIVATE)
    List<LessonEntity> findByVisibility(Visibility visibility);

    // Filtrar por published (true / false)
    List<LessonEntity> findByPublished(boolean published);

    List<LessonEntity> findByJapaneseLevelsAndPublishedTrueAndVisibility(JapaneseLevels japaneseLevels, Visibility visibility);

}
