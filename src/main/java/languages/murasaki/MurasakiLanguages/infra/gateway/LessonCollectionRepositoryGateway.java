package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection.LessonCollectionEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection.LessonsCollectionEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection.LessonsCollectionRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LessonCollectionRepositoryGateway implements LessonCollectionGateway {

    private final LessonsCollectionRepository lessonsCollectionRepository;
    private final LessonCollectionEntityMapper lessonCollectionEntityMapper;

    public LessonCollectionRepositoryGateway(LessonsCollectionRepository lessonsCollectionRepository, LessonCollectionEntityMapper lessonCollectionEntityMapper) {
        this.lessonsCollectionRepository = lessonsCollectionRepository;
        this.lessonCollectionEntityMapper = lessonCollectionEntityMapper;
    }

    @Override
    public LessonCollection createLessonCollection(LessonCollection lessonCollection) {
        LessonsCollectionEntity entity = lessonCollectionEntityMapper.toEntity(lessonCollection);
        lessonsCollectionRepository.save(entity);
        return lessonCollectionEntityMapper.toDomain(entity);
    }

    @Override
    @Cacheable(value = "lesson-collection")
    public List<LessonCollection> getAllCollections() {
        return lessonsCollectionRepository.findAll().stream().map(lessonCollectionEntityMapper::toDomain).toList();
    }

    @Override
    public LessonCollection getLessonCollectionById(String collectionId) {
        return lessonsCollectionRepository.findById(collectionId).map(lessonCollectionEntityMapper::toDomain).orElse(null);
    }

    @Override
    public LessonCollection updateCollection(String collectionId, LessonCollection lessonCollection) {
        Optional<LessonsCollectionEntity> entity = lessonsCollectionRepository.findById(collectionId);

        if(entity.isPresent()){
            LessonsCollectionEntity update = entity.get();

            update.setLanguageName(lessonCollection.languageName());
            update.setStatus(lessonCollection.status());

            lessonsCollectionRepository.save(update);

            return lessonCollectionEntityMapper.toDomain(update);
        }

        return null;
    }
}
