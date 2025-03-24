package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;

public class GetCourseCollectionByIdUsecaseImpl implements GetCourseCollectionByIdUsecase {

    private final CourseCollectionGateway courseCollectionGateway;

    public GetCourseCollectionByIdUsecaseImpl(CourseCollectionGateway courseCollectionGateway) {
        this.courseCollectionGateway = courseCollectionGateway;
    }

    @Override
    public CourseCollection execute(String collectionId) {
        return courseCollectionGateway.getCourseCollectionById(collectionId);
    }
}
