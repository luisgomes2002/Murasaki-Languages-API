package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.CreateExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.DeleteExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.GetExplanationByIdUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation.UpdateExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.AddExplanationUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.RemoveExplanationUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.ExplanationDto;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.WorksheetsDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.ExplanationDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/explanation/")
public class ExplanationController {

    private final CreateExplanationUsecase createExplanationUsecase;
    private final DeleteExplanationUsecase deleteExplanationUsecase;
    private final GetExplanationByIdUsecase getExplanationByIdUsecase;
    private final UpdateExplanationUsecase updateExplanationUsecase;
    private final ExplanationDtoMapper explanationDtoMapper;
    private final AddExplanationUsecase addExplanationUsecase;
    private final CreateBacklogUsecase createBacklogUsecase;
    private final RemoveExplanationUsecase removeExplanationUsecase;

    public ExplanationController(CreateExplanationUsecase createExplanationUsecase, DeleteExplanationUsecase deleteExplanationUsecase, GetExplanationByIdUsecase getExplanationByIdUsecase, UpdateExplanationUsecase updateExplanationUsecase, ExplanationDtoMapper explanationDtoMapper, AddExplanationUsecase addExplanationUsecase, CreateBacklogUsecase createBacklogUsecase, RemoveExplanationUsecase removeExplanationUsecase) {
        this.createExplanationUsecase = createExplanationUsecase;
        this.deleteExplanationUsecase = deleteExplanationUsecase;
        this.getExplanationByIdUsecase = getExplanationByIdUsecase;
        this.updateExplanationUsecase = updateExplanationUsecase;
        this.explanationDtoMapper = explanationDtoMapper;
        this.addExplanationUsecase = addExplanationUsecase;
        this.createBacklogUsecase = createBacklogUsecase;
        this.removeExplanationUsecase = removeExplanationUsecase;
    }

    @PostMapping("create/{lessonId}/{userId}")
    public ResponseEntity<Map<String, Object>> createExplanation(@PathVariable String lessonId, @RequestBody ExplanationDto explanationDto, @PathVariable String userId){
        Explanation newExplanation = createExplanationUsecase.execute(explanationDtoMapper.toDomain(explanationDto));
        Map<String, Object > response = new HashMap<>();
        response.put("Message: ", "Explicação criada com sucesso.");
        response.put("Explanation data: ", explanationDtoMapper.toDto(newExplanation));

        addExplanationUsecase.execute(lessonId, newExplanation.id());

        Backlog backlog = new Backlog(null, userId,"Criou um explicação", null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{explanationId}")
    public Explanation getExplanation(@PathVariable String explanationId) {return getExplanationByIdUsecase.execute(explanationId);}

    @DeleteMapping("delete/{explanationId}/{lessonId}/{userId}")
    public String deleteExplanation(@PathVariable String explanationId, @PathVariable String lessonId, @PathVariable String userId){
        deleteExplanationUsecase.execute(explanationId);
        removeExplanationUsecase.execute(lessonId, explanationId);

        Backlog backlog = new Backlog(null, userId, "Deletou uma explicação: " + explanationId, null);
        createBacklogUsecase.execute(backlog);

        return "Atividade deletada";
    }

    @PutMapping("update/{explanationId}/{userId}")
    public ResponseEntity<Map<String, Object>> updateExplanation(@PathVariable String explanationId, @PathVariable String userId, @RequestBody ExplanationDto explanationDto){
        Explanation explanation = updateExplanationUsecase.execute(explanationId, explanationDtoMapper.toDomain(explanationDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Explicação atualizada");
        response.put("Worksheet data: ", explanationDtoMapper.toDto(explanation));

        Backlog backlog = new Backlog(null, userId, "Atualizou uma explicação: " + explanation.id(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
