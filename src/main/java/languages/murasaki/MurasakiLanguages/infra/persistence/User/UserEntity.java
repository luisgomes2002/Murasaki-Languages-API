package languages.murasaki.MurasakiLanguages.infra.persistence.User;

import languages.murasaki.MurasakiLanguages.core.enums.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "User")
public class UserEntity {

    @Id
    private String id;

    private String name;
    private String username;
    private String email;
    private String password;
    private String icon;
    private String background;
    private List<String> followersId;
    private List<String> followingId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String about;
    private UserType userType;
    private List<String> notificationsId;
    private List<String> postsId;
    private boolean ban;

    public UserEntity() {
    }

    public UserEntity(String id, String name, String username, String email, String password, String icon, String background, List<String> followersId, List<String> followingId, LocalDateTime createdAt, LocalDateTime updatedAt, String about, UserType userType, List<String> notificationsId, List<String> postsId, boolean ban) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.icon = icon;
        this.background = background;
        this.followersId = followersId;
        this.followingId = followingId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.about = about;
        this.userType = userType;
        this.notificationsId = notificationsId;
        this.postsId = postsId;
        this.ban = ban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<String> getFollowersId() {
        return followersId;
    }

    public void setFollowersId(List<String> followersId) {
        this.followersId = followersId;
    }

    public List<String> getFollowingId() {
        return followingId;
    }

    public void setFollowingId(List<String> followingId) {
        this.followingId = followingId;
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

    public List<String> getNotificationsId() {
        return notificationsId;
    }

    public void setNotificationsId(List<String> notificationsId) {
        this.notificationsId = notificationsId;
    }

    public List<String> getPostsId() {
        return postsId;
    }

    public void setPostsId(List<String> postsId) {
        this.postsId = postsId;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }
}

