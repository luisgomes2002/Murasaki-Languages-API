package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;

public interface GetCourseCollectionByIdUsecase {

    CourseCollection execute(String collectionId);
}
