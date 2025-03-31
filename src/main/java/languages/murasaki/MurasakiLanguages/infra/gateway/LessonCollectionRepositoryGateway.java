package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lessonCollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.lessoncollection.LessonCollectionEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection.LessonsCollectionEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection.LessonCollectionRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonCollectionRepositoryGateway implements LessonCollectionGateway {

    private final LessonCollectionRepository lessonCollectionRepository;
    private final LessonCollectionEntityMapper lessonCollectionEntityMapper;

    public LessonCollectionRepositoryGateway(LessonCollectionRepository lessonCollectionRepository, LessonCollectionEntityMapper lessonCollectionEntityMapper) {
        this.lessonCollectionRepository = lessonCollectionRepository;
        this.lessonCollectionEntityMapper = lessonCollectionEntityMapper;
    }

    @Override
    public lessonCollection createLessonCollection(lessonCollection lessonCollection) {
        LessonsCollectionEntity entity = lessonCollectionEntityMapper.toEntity(lessonCollection);
        lessonCollectionRepository.save(entity);
        return lessonCollectionEntityMapper.toDomain(entity);
    }

    @Override
    @Cacheable(value = "lesson-collection")
    public List<lessonCollection> getAllCollections() {
        return lessonCollectionRepository.findAll().stream().map(lessonCollectionEntityMapper::toDomain).toList();
    }

    @Override
    public lessonCollection getLessonCollectionById(String collectionId) {
        return lessonCollectionRepository.findById(collectionId).map(lessonCollectionEntityMapper::toDomain).orElse(null);
    }

    @Override
    public String publishLessonInCollection(String collectionId, String lessonId, boolean status) {
        lessonCollection lessonCollection = getLessonCollectionById(collectionId);

        if (status) lessonCollection.lessonId().add(lessonId);
        else lessonCollection.lessonId().remove(lessonId);

        lessonCollectionRepository.save(lessonCollectionEntityMapper.toEntity(lessonCollection));

        return status ? "Status atualizado: Publicado" : "Status atualizado: Arquivado";
    }
}
