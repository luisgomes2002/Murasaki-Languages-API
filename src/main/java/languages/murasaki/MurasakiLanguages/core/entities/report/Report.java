package languages.murasaki.MurasakiLanguages.core.entities.report;

import languages.murasaki.MurasakiLanguages.core.enums.ReportType;

public record Report(String id, String userId, String objectId, ReportType reportType, String text, boolean finished) {
}
