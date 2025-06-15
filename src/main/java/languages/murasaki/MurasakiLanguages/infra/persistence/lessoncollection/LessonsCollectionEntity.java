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
    private boolean status;

    public LessonsCollectionEntity() {
    }

    public LessonsCollectionEntity(String id, String languageName, boolean status) {
        this.id = id;
        this.languageName = languageName;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
