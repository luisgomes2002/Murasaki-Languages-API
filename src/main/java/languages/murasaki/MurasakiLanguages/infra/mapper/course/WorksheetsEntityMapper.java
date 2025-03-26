package languages.murasaki.MurasakiLanguages.infra.mapper.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Worksheets;
import languages.murasaki.MurasakiLanguages.infra.persistence.course.WorksheetsEntity;
import org.springframework.stereotype.Component;

@Component
public class WorksheetsEntityMapper {

    public WorksheetsEntity toEntity(Worksheets worksheets){
        return new WorksheetsEntity(
            worksheets.courseId(),
            worksheets.question(),
            worksheets.options(),
            worksheets.answer()
        );
    }

    public Worksheets toDomain(WorksheetsEntity worksheetsEntity){
        return new Worksheets(
            worksheetsEntity.getCourseId(),
            worksheetsEntity.getQuestion(),
            worksheetsEntity.getOptions(),
            worksheetsEntity.getAnswer()
        );
    }
}
