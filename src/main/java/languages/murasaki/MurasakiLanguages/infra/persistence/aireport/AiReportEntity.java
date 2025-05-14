package languages.murasaki.MurasakiLanguages.infra.persistence.aireport;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ai_report")
public class AiReportEntity {

    private String userId;
    private String report;

    public AiReportEntity() {
    }

    public AiReportEntity(String userId, String report) {
        this.userId = userId;
        this.report = report;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
