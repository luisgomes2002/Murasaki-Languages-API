package languages.murasaki.MurasakiLanguages.infra.mapper.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Explanation;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.ExplanationEntity;
import org.springframework.stereotype.Component;

@Component
public class ExplanationEntityMapper {

    public ExplanationEntity toEntity(Explanation explanation){
        return new ExplanationEntity(
            explanation.phrase(),
            explanation.translation(),
            explanation.explanation()
        );
    }

    public Explanation toDomain(ExplanationEntity explanation){
        return new Explanation(
            explanation.getPhrase(),
            explanation.getTranslation(),
            explanation.getExplanation()
        );
    }
}

