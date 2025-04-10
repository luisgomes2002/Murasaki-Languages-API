package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessonCollection.lessonCollection;

public interface GetLessonCollectionByIdUsecase {

    lessonCollection execute(String collectionId);
}
