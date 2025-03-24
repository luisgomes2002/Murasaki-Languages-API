package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;

public interface CreateCourseCollectionUsecase {

    public CourseCollection execute(CourseCollection courseCollection);
}
