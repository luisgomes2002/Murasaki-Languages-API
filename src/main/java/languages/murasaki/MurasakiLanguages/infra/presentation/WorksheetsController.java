package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.UpdateExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets.CreateWorksheetsUseCase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets.DeleteWorksheetsUseCase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets.GetWorksheetsByIdUseCase;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.WorksheetsDtoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/work-sheets/")
public class WorksheetsController {

    private final CreateWorksheetsUseCase createWorksheetsUseCase;
    private final DeleteWorksheetsUseCase deleteWorksheetsUseCase;
    private final GetWorksheetsByIdUseCase getWorksheetsByIdUseCase;
    private final UpdateExplanationUsecase updateExplanationUsecase;
    private final WorksheetsDtoMapper worksheetsDtoMapper;

    public WorksheetsController(CreateWorksheetsUseCase createWorksheetsUseCase, DeleteWorksheetsUseCase deleteWorksheetsUseCase, GetWorksheetsByIdUseCase getWorksheetsByIdUseCase, UpdateExplanationUsecase updateExplanationUsecase, WorksheetsDtoMapper worksheetsDtoMapper) {
        this.createWorksheetsUseCase = createWorksheetsUseCase;
        this.deleteWorksheetsUseCase = deleteWorksheetsUseCase;
        this.getWorksheetsByIdUseCase = getWorksheetsByIdUseCase;
        this.updateExplanationUsecase = updateExplanationUsecase;
        this.worksheetsDtoMapper = worksheetsDtoMapper;
    }
}
