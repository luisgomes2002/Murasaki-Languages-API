package languages.murasaki.MurasakiLanguages.infra.persistence.metrics;

import languages.murasaki.MurasakiLanguages.core.enums.Gender;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "metrics")
public class MetricsEntity {

    @Id
    private String id;

    private LocalDateTime date;
    private int totalUsers;
    private int activeUsers;
    private int bannedUsers;
    private int deletedUsers;
    private Map<String, Integer> userAgeDistribution;
    private Map<LanguageType, Integer> topLanguages;
    private Map<Gender, Integer> topGender;

    public MetricsEntity() {
    }

    public MetricsEntity(String id, LocalDateTime date, int totalUsers, int activeUsers, int bannedUsers, int deletedUsers, Map<String, Integer> userAgeDistribution, Map<LanguageType, Integer> topLanguages, Map<Gender, Integer> topGender) {
        this.id = id;
        this.date = date;
        this.totalUsers = totalUsers;
        this.activeUsers = activeUsers;
        this.bannedUsers = bannedUsers;
        this.deletedUsers = deletedUsers;
        this.userAgeDistribution = userAgeDistribution;
        this.topLanguages = topLanguages;
        this.topGender = topGender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(int activeUsers) {
        this.activeUsers = activeUsers;
    }

    public int getBannedUsers() {
        return bannedUsers;
    }

    public void setBannedUsers(int bannedUsers) {
        this.bannedUsers = bannedUsers;
    }

    public int getDeletedUsers() {
        return deletedUsers;
    }

    public void setDeletedUsers(int deletedUsers) {
        this.deletedUsers = deletedUsers;
    }

    public Map<String, Integer> getUserAgeDistribution() {
        return userAgeDistribution;
    }

    public void setUserAgeDistribution(Map<String, Integer> userAgeDistribution) {
        this.userAgeDistribution = userAgeDistribution;
    }

    public Map<LanguageType, Integer> getTopLanguages() {
        return topLanguages;
    }

    public void setTopLanguages(Map<LanguageType, Integer> topLanguages) {
        this.topLanguages = topLanguages;
    }

    public Map<Gender, Integer> getTopGender() {
        return topGender;
    }

    public void setTopGender(Map<Gender, Integer> topGender) {
        this.topGender = topGender;
    }
}
