package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.courseCollection.CourseCollection;

import java.util.List;

public interface CourseCollectionGateway {

    CourseCollection createCourseCollection(CourseCollection courseCollection);
    List<CourseCollection> getAllCollections();
    CourseCollection getCourseCollectionById(String collectionId);

    String publishCourseInCollection(String collectionId, String courseId, boolean status);
}
