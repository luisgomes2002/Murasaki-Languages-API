package languages.murasaki.MurasakiLanguages.infra.persistence;

import languages.murasaki.MurasakiLanguages.core.Enums.UserType;
import languages.murasaki.MurasakiLanguages.core.entities.Post;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collation = "User")
public class UserEntity {

    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String background;
    private String followers;
    private String following;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String about;
    private UserType userType;
    private List<String> notification;

    public UserEntity() {
    }

    public UserEntity(String name, String username, String email, String password, String avatar, String background, String followers, String following, LocalDateTime createdAt, LocalDateTime updatedAt, String about, UserType userType, List<String> notification) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.background = background;
        this.followers = followers;
        this.following = following;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.about = about;
        this.userType = userType;
        this.notification = notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<String> getNotification() {
        return notification;
    }

    public void setNotification(List<String> notification) {
        this.notification = notification;
    }

}
