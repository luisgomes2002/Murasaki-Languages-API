package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;

import java.util.List;

public class GetAllCollectionsUsecaseImpl implements GetAllCollectionsUsecase{

    private final LessonCollectionGateway lessonCollectionGateway;

    public GetAllCollectionsUsecaseImpl(LessonCollectionGateway lessonCollectionGateway) {
        this.lessonCollectionGateway = lessonCollectionGateway;
    }

    @Override
    public List<LessonCollection> execute() {
        return lessonCollectionGateway.getAllCollections();
    }
}
