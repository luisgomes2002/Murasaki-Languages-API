package languages.murasaki.MurasakiLanguages.infra.persistence.report;

import languages.murasaki.MurasakiLanguages.core.enums.ReportType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course-report")
public class ReportEntity {

    @Id
    private String id;

    private String userId;
    private String objectId;
    private ReportType reportType;
    private String user;
    private String text;
    private boolean finished;

    public ReportEntity() {
    }

    public ReportEntity(String id, String userId, String objectId, ReportType reportType, String user, String text, boolean finished) {
        this.id = id;
        this.userId = userId;
        this.objectId = objectId;
        this.reportType = reportType;
        this.user = user;
        this.text = text;
        this.finished = finished;
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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
