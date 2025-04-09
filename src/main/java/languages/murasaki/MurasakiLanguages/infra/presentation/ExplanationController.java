package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.CreateExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.DeleteExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.GetExplanationByIdUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.UpdateExplanationUsecase;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.ExplanationDtoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/explanation/")
public class ExplanationController {

    private final CreateExplanationUsecase createExplanationUsecase;
    private final DeleteExplanationUsecase deleteExplanationUsecase;
    private final GetExplanationByIdUsecase getExplanationByIdUsecase;
    private final UpdateExplanationUsecase updateExplanationUsecase;
    private final ExplanationDtoMapper explanationDtoMapper;

    public ExplanationController(CreateExplanationUsecase createExplanationUsecase, DeleteExplanationUsecase deleteExplanationUsecase, GetExplanationByIdUsecase getExplanationByIdUsecase, UpdateExplanationUsecase updateExplanationUsecase, ExplanationDtoMapper explanationDtoMapper) {
        this.createExplanationUsecase = createExplanationUsecase;
        this.deleteExplanationUsecase = deleteExplanationUsecase;
        this.getExplanationByIdUsecase = getExplanationByIdUsecase;
        this.updateExplanationUsecase = updateExplanationUsecase;
        this.explanationDtoMapper = explanationDtoMapper;
    }
}
