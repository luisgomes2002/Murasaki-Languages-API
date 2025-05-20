package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends MongoRepository<LessonEntity, String> {

    // Filtrar por visibility (PUBLIC ou PRIVATE)
    Page<LessonEntity> findByVisibility(Visibility visibility, Pageable pageable);

    // Filtrar por published (true / false)
    Page<LessonEntity> findByPublished(boolean published, Pageable pageable);

    Page<LessonEntity> findByJapaneseLevelsAndPublishedTrueAndVisibility(JapaneseLevels japaneseLevels, Visibility visibility, Pageable pageable);

    Page<LessonEntity> findByJapaneseLevelsAndPublishedTrue(JapaneseLevels japaneseLevels, Pageable pageable);
}
