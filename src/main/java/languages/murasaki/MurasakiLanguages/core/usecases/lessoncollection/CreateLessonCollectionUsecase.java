package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;

public interface CreateLessonCollectionUsecase {

    public LessonCollection execute(LessonCollection lessonCollection);
}
