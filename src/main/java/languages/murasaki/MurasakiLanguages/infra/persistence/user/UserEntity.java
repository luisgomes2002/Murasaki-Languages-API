package languages.murasaki.MurasakiLanguages.infra.persistence.user;

import languages.murasaki.MurasakiLanguages.core.enums.Gender;
import languages.murasaki.MurasakiLanguages.core.enums.SubscriptionType;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
public class UserEntity implements UserDetails{

    @Id
    private String id;

    private String name;
    private String username;
    private Gender gender;
    private LocalDate birth;
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
    private boolean isEnabled;
    private boolean isBanned;
    private SubscriptionType subscription;

    public UserEntity() {
    }

    public UserEntity(String id, String name, String username, Gender gender, LocalDate birth, String email, String password, String icon, String background, List<String> followersId, List<String> followingId, LocalDateTime createdAt, LocalDateTime updatedAt, String about, UserType userType, List<String> notificationsId, List<String> postsId, boolean isEnabled, boolean isBanned, SubscriptionType subscription) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.birth = birth;
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
        this.isEnabled = isEnabled;
        this.isBanned = isBanned;
        this.subscription = subscription;
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

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
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

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public SubscriptionType getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionType subscription) {
        this.subscription = subscription;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override // Olhar no video da Fernanda Kipper
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}

