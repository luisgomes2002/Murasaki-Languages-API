package languages.murasaki.MurasakiLanguages.infra.persistence.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "user_reports")
public class UserReportEntity {

    @Id
    private String id;
    private String userId;
    private String name;
    private LocalDateTime updatedAt;
    private List<UserReportDetail> reports;

    public UserReportEntity() {
    }

    public UserReportEntity(String id, String userId, String name, LocalDateTime updatedAt, List<UserReportDetail> reports) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.updatedAt = updatedAt;
        this.reports = reports;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<UserReportDetail> getReports() {
        return reports;
    }

    public void setReports(List<UserReportDetail> reports) {
        this.reports = reports;
    }
}
