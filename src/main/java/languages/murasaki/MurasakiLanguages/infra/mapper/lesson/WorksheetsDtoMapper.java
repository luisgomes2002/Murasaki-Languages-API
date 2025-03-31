package languages.murasaki.MurasakiLanguages.infra.mapper.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.WorksheetsDto;
import org.springframework.stereotype.Component;

@Component
public class WorksheetsDtoMapper {

    public WorksheetsDto toDto(Worksheets worksheets){
        return new WorksheetsDto(
            worksheets.lessonId(),
            worksheets.question(),
            worksheets.options(),
            worksheets.answer()
        );
    }

    public Worksheets toDomain(WorksheetsDto worksheetsDto){
        return new Worksheets(
            worksheetsDto.lessonId(),
            worksheetsDto.question(),
            worksheetsDto.options(),
            worksheetsDto.answer()
        );
    }
}
