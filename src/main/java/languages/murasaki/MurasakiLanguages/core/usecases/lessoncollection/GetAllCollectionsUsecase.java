package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;

import java.util.List;

public interface GetAllCollectionsUsecase {

    public List<LessonCollection> execute();
}
