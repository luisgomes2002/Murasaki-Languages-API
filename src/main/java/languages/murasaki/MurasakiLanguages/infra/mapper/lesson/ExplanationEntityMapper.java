package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.ExplanationEntity;
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

