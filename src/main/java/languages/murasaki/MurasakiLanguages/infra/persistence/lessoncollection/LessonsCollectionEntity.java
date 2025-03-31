package languages.murasaki.MurasakiLanguages.infra.persistence.lessoncollection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "lesson-collections")
public class LessonsCollectionEntity {

    @Id
    private String id;

    private String languageName;
    private List<String> lessonsId;

    public LessonsCollectionEntity() {
    }

    public LessonsCollectionEntity(String id, String languageName, List<String> lessonsId) {
        this.id = id;
        this.languageName = languageName;
        this.lessonsId = (lessonsId != null) ? new ArrayList<>(lessonsId) : new ArrayList<>();
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

    public List<String> getLessonsId() {
        return lessonsId;
    }

    public void setLessonsId(List<String> lessonsId) {
        this.lessonsId = lessonsId;
    }
}
