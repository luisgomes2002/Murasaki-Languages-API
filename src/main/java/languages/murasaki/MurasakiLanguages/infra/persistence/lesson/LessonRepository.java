package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends MongoRepository<LessonEntity, String> {

    // Filtrar por visibility (PUBLIC ou PRIVATE)
    Page<LessonEntity> findByVisibility(Visibility visibility, Pageable pageable);

    // Filtrar por published (true / false)
    Page<LessonEntity> findByPublished(boolean published, Pageable pageable);

    Page<LessonEntity> findByJapaneseLevelsAndPublishedTrueAndVisibility(LanguagesLevels languagesLevels, Visibility visibility, Pageable pageable);

    Page<LessonEntity> findByPublishedTrueAndVisibility(Visibility visibility, Pageable pageable);

    Page<LessonEntity> findByPublishedTrueAndLanguageType(LanguageType languageType, Pageable pageable);

    Page<LessonEntity> findByJapaneseLevelsAndPublishedTrue(LanguagesLevels languagesLevels, Pageable pageable);
}
