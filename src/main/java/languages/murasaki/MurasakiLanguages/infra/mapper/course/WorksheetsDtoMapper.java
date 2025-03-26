package languages.murasaki.MurasakiLanguages.infra.mapper.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Worksheets;
import languages.murasaki.MurasakiLanguages.infra.dtos.course.WorksheetsDto;
import org.springframework.stereotype.Component;

@Component
public class WorksheetsDtoMapper {

    public WorksheetsDto toDto(Worksheets worksheets){
        return new WorksheetsDto(
            worksheets.courseId(),
            worksheets.question(),
            worksheets.options(),
            worksheets.answer()
        );
    }

    public Worksheets toDomain(WorksheetsDto worksheetsDto){
        return new Worksheets(
            worksheetsDto.courseId(),
            worksheetsDto.question(),
            worksheetsDto.options(),
            worksheetsDto.answer()
        );
    }
}
