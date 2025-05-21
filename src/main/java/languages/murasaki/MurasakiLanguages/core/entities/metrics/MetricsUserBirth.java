package languages.murasaki.MurasakiLanguages.core.entities.metrics;

import java.time.LocalDateTime;
import java.util.List;

public record MetricsUserBirth(String id, LocalDateTime date, List<UsersBirth> usersBirths) {
}
