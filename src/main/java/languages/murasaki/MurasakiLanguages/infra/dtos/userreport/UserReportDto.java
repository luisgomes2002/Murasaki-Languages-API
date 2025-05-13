package languages.murasaki.MurasakiLanguages.infra.dtos.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;

import java.time.LocalDateTime;
import java.util.List;

public record UserReportDto(String id, String userId, String name, LocalDateTime updatedAt, List<UserReportDetail> reports) {
}
