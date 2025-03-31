package languages.murasaki.MurasakiLanguages.infra.persistence.backlog;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "backlog")
public class BacklogEntity {

    @Id
    private String id;

    private String user;
    private String description;
    private LocalDateTime createdAt;

    public BacklogEntity() {
    }

    public BacklogEntity(String id, String user, String description, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
