package languages.murasaki.MurasakiLanguages.infrastructure.persistence.post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Post")
public class PostEntity {

    @Id
    private String id;

    private String title;
    private String text;
    private String banner;
    private String userId;
    private List<Integer> likes;
    private List<CommentEntity> commentsList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostEntity() {
    }

    public PostEntity(String id, String title, String text, String banner, String userId, List<Integer> likes, List<CommentEntity> commentsList, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.banner = banner;
        this.userId = userId;
        this.likes = likes;
        this.commentsList = commentsList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Integer> getLikes() {
        return likes;
    }

    public void setLikes(List<Integer> likes) {
        this.likes = likes;
    }

    public List<CommentEntity> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<CommentEntity> commentsList) {
        this.commentsList = commentsList;
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
}
