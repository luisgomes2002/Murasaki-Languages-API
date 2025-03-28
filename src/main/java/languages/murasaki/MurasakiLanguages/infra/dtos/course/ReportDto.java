package languages.murasaki.MurasakiLanguages.infra.dtos.course;

import languages.murasaki.MurasakiLanguages.core.enums.ReportType;

public record ReportDto(String id, String userId, String objectId, ReportType reportType, String user, String text, boolean finished) {
}