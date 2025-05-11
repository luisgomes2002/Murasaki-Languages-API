package languages.murasaki.MurasakiLanguages.core.entities.userreport;

import java.time.LocalDateTime;
import java.util.List;

public record UserReport(String id, String userId, String name, LocalDateTime updatedAt, List<String> reports) {
}
