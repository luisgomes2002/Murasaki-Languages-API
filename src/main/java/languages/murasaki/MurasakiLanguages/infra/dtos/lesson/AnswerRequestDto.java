package languages.murasaki.MurasakiLanguages.infra.dtos.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;

public record AnswerRequestDto(
        Worksheets worksheets,
        String answer
) {
}
