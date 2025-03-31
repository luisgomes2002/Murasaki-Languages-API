package languages.murasaki.MurasakiLanguages.infra.dtos.report;

import languages.murasaki.MurasakiLanguages.core.enums.ReportType;

public record ReportDto(String id, String userId, String objectId, ReportType reportType, String text, boolean finished) {
}