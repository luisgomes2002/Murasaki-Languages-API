package languages.murasaki.MurasakiLanguages.infra.dtos.course;

import java.util.List;

public record WorksheetsDto(String courseId, String question, List<String> options, String answer) {
}
