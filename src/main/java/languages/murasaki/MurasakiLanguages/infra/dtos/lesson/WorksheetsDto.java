package languages.murasaki.MurasakiLanguages.infra.dtos.lesson;

import java.util.List;

public record WorksheetsDto(String lessonId, String question, List<String> options, String answer) {
}
