package languages.murasaki.MurasakiLanguages.infra.dtos.userreport;

import java.time.LocalDateTime;
import java.util.List;

public record UserReportDto(String id, String userId, String name, LocalDateTime updatedAt, List<String> reports) {
}
