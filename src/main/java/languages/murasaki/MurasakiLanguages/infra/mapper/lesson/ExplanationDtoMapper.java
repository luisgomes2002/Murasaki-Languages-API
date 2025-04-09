package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.ExplanationDto;
import org.springframework.stereotype.Component;

@Component
public class ExplanationDtoMapper {

    public ExplanationDto toDto(Explanation explanation){
        return new ExplanationDto(
            explanation.id(),
            explanation.phrase(),
            explanation.translation(),
            explanation.explanation()
        );
    }

    public Explanation toDomain(ExplanationDto explanationDto){
        return new Explanation(
            explanationDto.id(),
            explanationDto.phrase(),
            explanationDto.translation(),
            explanationDto.explanation()
        );
    }
}
