package languages.murasaki.MurasakiLanguages.infra.mapper.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Explanation;
import languages.murasaki.MurasakiLanguages.infra.dtos.course.ExplanationDto;
import org.springframework.stereotype.Component;

@Component
public class ExplanationDtoMapper {

    public ExplanationDto toDto(Explanation explanation){
        return new ExplanationDto(
            explanation.phrase(),
            explanation.translation(),
            explanation.explanation()
        );
    }

    public Explanation toDomain(ExplanationDto explanationDto){
        return new Explanation(
            explanationDto.phrase(),
            explanationDto.translation(),
            explanationDto.explanation()
        );
    }
}
