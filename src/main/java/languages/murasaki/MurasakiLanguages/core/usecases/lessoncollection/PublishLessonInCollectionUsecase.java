package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

public interface PublishLessonInCollectionUsecase {

    String execute(String collectionId, String lessonId, boolean status);
}
