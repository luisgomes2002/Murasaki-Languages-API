package languages.murasaki.MurasakiLanguages.core.usecases.courseCollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;

import java.util.List;

public interface GetAllCollectionsUsecase {

    public List<CourseCollection> execute();
}
