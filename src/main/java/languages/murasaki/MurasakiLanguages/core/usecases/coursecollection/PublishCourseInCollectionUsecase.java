package languages.murasaki.MurasakiLanguages.core.usecases.coursecollection;

public interface PublishCourseInCollectionUsecase {

    String execute(String collectionId, String courseId, boolean status);
}
