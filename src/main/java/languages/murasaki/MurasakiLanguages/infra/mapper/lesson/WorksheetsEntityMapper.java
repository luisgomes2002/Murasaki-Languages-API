package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.WorksheetsEntity;
import org.springframework.stereotype.Component;

@Component
public class WorksheetsEntityMapper {

    public WorksheetsEntity toEntity(Worksheets worksheets){
        return new WorksheetsEntity(
            worksheets.id(),
            worksheets.question(),
            worksheets.options(),
            worksheets.answer(),
            worksheets.explanation()
        );
    }

    public Worksheets toDomain(WorksheetsEntity worksheetsEntity){
        return new Worksheets(
            worksheetsEntity.getId(),
            worksheetsEntity.getQuestion(),
            worksheetsEntity.getOptions(),
            worksheetsEntity.getAnswer(),
            worksheetsEntity.getExplanation()
        );
    }
}
