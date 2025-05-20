package languages.murasaki.MurasakiLanguages.core.entities.metrics;

import java.time.LocalDate;
import java.util.List;

public record MetricsDate(String id, List<LocalDate> dateTimes){
}
