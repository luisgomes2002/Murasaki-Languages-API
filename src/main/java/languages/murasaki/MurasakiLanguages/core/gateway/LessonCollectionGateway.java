package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.lessonCollection;

import java.util.List;

public interface LessonCollectionGateway {

    lessonCollection createLessonCollection(lessonCollection lessonCollection);
    List<lessonCollection> getAllCollections();
    lessonCollection getLessonCollectionById(String collectionId);

    String publishLessonInCollection(String collectionId, String lessonId, boolean status);
}
