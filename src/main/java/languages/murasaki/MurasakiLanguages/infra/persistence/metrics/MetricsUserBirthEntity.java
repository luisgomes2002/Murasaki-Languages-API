package languages.murasaki.MurasakiLanguages.infra.persistence.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.UsersBirth;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "metrics_birth")
public class MetricsUserBirthEntity {

    @Id
    private String id;
    private LocalDateTime date;
    private List<UsersBirth> usersBirths;

    public MetricsUserBirthEntity() {
    }

    public MetricsUserBirthEntity(String id, LocalDateTime date, List<UsersBirth> usersBirths) {
        this.id = id;
        this.date = date;
        this.usersBirths = usersBirths;
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

    public List<UsersBirth> getUsersBirths() {
        return usersBirths;
    }

    public void setUsersBirths(List<UsersBirth> usersBirths) {
        this.usersBirths = usersBirths;
    }
}
