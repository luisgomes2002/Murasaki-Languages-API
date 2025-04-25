package languages.murasaki.MurasakiLanguages.infra.dtos.lesson;

import java.util.List;

public record WorksheetsDto(String id, String question, List<String> options, String answer, String explanation) {
}
