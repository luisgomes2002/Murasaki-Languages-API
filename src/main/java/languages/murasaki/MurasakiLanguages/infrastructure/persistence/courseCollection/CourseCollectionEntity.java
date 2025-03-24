package languages.murasaki.MurasakiLanguages.infrastructure.persistence.courseCollection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "CourseCollection")
public class CourseCollectionEntity {

    @Id
    private String id;

    private String languageName;
    private List<String> coursesId;

    public CourseCollectionEntity() {
    }

    public CourseCollectionEntity(String id, String languageName, List<String> coursesId) {
        this.id = id;
        this.languageName = languageName;
        this.coursesId = coursesId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<String> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<String> coursesId) {
        this.coursesId = coursesId;
    }
}
