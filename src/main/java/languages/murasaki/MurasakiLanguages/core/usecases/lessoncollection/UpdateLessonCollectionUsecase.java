package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;

public interface UpdateLessonCollectionUsecase {
  LessonCollection execute(String collectionId, LessonCollection lessonCollection);
}
