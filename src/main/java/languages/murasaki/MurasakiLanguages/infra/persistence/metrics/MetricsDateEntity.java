package languages.murasaki.MurasakiLanguages.infra.persistence.metrics;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

public class MetricsDateEntity{

    @Id
    private String id;
    private List<LocalDate> dateTimes;

    public MetricsDateEntity() {
    }

    public MetricsDateEntity(String id, List<LocalDate> dateTimes) {
        this.id = id;
        this.dateTimes = dateTimes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LocalDate> getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(List<LocalDate> dateTimes) {
        this.dateTimes = dateTimes;
    }
}
