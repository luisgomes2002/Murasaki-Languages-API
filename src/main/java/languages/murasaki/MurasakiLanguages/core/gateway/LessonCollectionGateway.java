package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;

import java.util.List;

public interface LessonCollectionGateway {

    LessonCollection createLessonCollection(LessonCollection lessonCollection);
    List<LessonCollection> getAllCollections();
    LessonCollection getLessonCollectionById(String collectionId);
    LessonCollection updateCollection(String collectionId, LessonCollection lessonCollection);
}
