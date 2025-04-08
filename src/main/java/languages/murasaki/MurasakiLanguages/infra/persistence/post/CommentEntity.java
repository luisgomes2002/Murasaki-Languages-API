package languages.murasaki.MurasakiLanguages.infra.persistence.post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "comments")
public class CommentEntity {

    @Id
    private String id;

    private String message;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CommentEntity> replies;

    public CommentEntity() {
    }

    public CommentEntity(String id, String message, String username, LocalDateTime createdAt, LocalDateTime updatedAt, List<CommentEntity> replies) {
        this.id = id;
        this.message = message;
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.replies = replies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CommentEntity> getReplies() {
        return replies;
    }

    public void setReplies(List<CommentEntity> replies) {
        this.replies = replies;
    }
}
