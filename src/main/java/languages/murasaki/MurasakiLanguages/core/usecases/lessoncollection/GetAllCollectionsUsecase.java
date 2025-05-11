package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.lessonCollection;

import java.util.List;

public interface GetAllCollectionsUsecase {

    public List<lessonCollection> execute();
}
