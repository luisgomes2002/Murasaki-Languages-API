package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.WorksheetsEntity;
import org.springframework.stereotype.Component;

@Component
public class WorksheetsEntityMapper {

    public WorksheetsEntity toEntity(Worksheets worksheets){
        return new WorksheetsEntity(
            worksheets.lessonId(),
            worksheets.question(),
            worksheets.options(),
            worksheets.answer()
        );
    }

    public Worksheets toDomain(WorksheetsEntity worksheetsEntity){
        return new Worksheets(
            worksheetsEntity.getLessonId(),
            worksheetsEntity.getQuestion(),
            worksheetsEntity.getOptions(),
            worksheetsEntity.getAnswer()
        );
    }
}
