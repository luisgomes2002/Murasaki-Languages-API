package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;

public class PublishCourseInCollectionUsecaseImpl implements PublishCourseInCollectionUsecase {

    public final CourseCollectionGateway courseCollectionGateway;

    public PublishCourseInCollectionUsecaseImpl(CourseCollectionGateway courseCollectionGateway) {
        this.courseCollectionGateway = courseCollectionGateway;
    }

    @Override
    public void execute(String collectionId, String courseId) {
        courseCollectionGateway.publishCourseInCollection(collectionId, courseId);
    }
}
