package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.AddWorksheetsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.RemoveWorksheetsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets.*;
import languages.murasaki.MurasakiLanguages.core.usecases.userreport.CreateUserReportUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.lesson.WorksheetsDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.WorksheetsDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/work-sheets/")
public class WorksheetsController {

    private final CreateWorksheetsUseCase createWorksheetsUseCase;
    private final DeleteWorksheetsUseCase deleteWorksheetsUseCase;
    private final GetWorksheetsByIdUseCase getWorksheetsByIdUseCase;
    private final WorksheetsDtoMapper worksheetsDtoMapper;
    private final AddWorksheetsUsecase addWorksheetsUsecase;
    private final CreateBacklogUsecase createBacklogUsecase;
    private final RemoveWorksheetsUsecase removeWorksheetsUsecase;
    private final UpdateWorksheetsUseCase updateWorksheetsUseCase;
    private final CreateUserReportUsecase createUserReportUsecase;
    private final AnswerUsecase answerUsecase;

    public WorksheetsController(CreateWorksheetsUseCase createWorksheetsUseCase, DeleteWorksheetsUseCase deleteWorksheetsUseCase, GetWorksheetsByIdUseCase getWorksheetsByIdUseCase, WorksheetsDtoMapper worksheetsDtoMapper, AddWorksheetsUsecase addWorksheetsUsecase, CreateBacklogUsecase createBacklogUsecase, RemoveWorksheetsUsecase removeWorksheetsUsecase, UpdateWorksheetsUseCase updateWorksheetsUseCase, CreateUserReportUsecase createUserReportUsecase, AnswerUsecase answerUsecase) {
        this.createWorksheetsUseCase = createWorksheetsUseCase;
        this.deleteWorksheetsUseCase = deleteWorksheetsUseCase;
        this.getWorksheetsByIdUseCase = getWorksheetsByIdUseCase;
        this.worksheetsDtoMapper = worksheetsDtoMapper;
        this.addWorksheetsUsecase = addWorksheetsUsecase;
        this.createBacklogUsecase = createBacklogUsecase;
        this.removeWorksheetsUsecase = removeWorksheetsUsecase;
        this.updateWorksheetsUseCase = updateWorksheetsUseCase;
        this.createUserReportUsecase = createUserReportUsecase;
        this.answerUsecase = answerUsecase;
    }

    @PostMapping("create/{lessonId}/{userId}")
    public ResponseEntity<Map<String, Object>> createWorksheet(@PathVariable String lessonId, @RequestBody WorksheetsDto worksheetsDto, @PathVariable String userId){
        Worksheets newWorksheet = createWorksheetsUseCase.execute(worksheetsDtoMapper.toDomain(worksheetsDto));
        Map<String, Object > response = new HashMap<>();
        response.put("Message: ", "Exercício criado com sucesso.");
        response.put("Worksheet data: ", worksheetsDtoMapper.toDto(newWorksheet));

        addWorksheetsUsecase.execute(lessonId, newWorksheet.id());

        Backlog backlog = new Backlog(null, userId,"Criou um exercício", null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{worksheetId}")
    public Worksheets getWorksheet(@PathVariable String worksheetId) {return getWorksheetsByIdUseCase.execute(worksheetId);}

    @DeleteMapping("delete/{worksheetId}/{lessonId}/{userId}")
    public String deleteWorksheet(@PathVariable String worksheetId, @PathVariable String lessonId, @PathVariable String userId){
        deleteWorksheetsUseCase.execute(worksheetId);
        removeWorksheetsUsecase.execute(lessonId, worksheetId);

        Backlog backlog = new Backlog(null, userId, "Deletou uma atividade: " + worksheetId, null);
        createBacklogUsecase.execute(backlog);

        return "Atividade deletada";
    }

    @PutMapping("update/{worksheetId}/{userId}")
    public ResponseEntity<Map<String, Object>> updateWorksheet(@PathVariable String worksheetId, @PathVariable String userId, @RequestBody WorksheetsDto worksheetsDto){
        Worksheets worksheets = updateWorksheetsUseCase.execute(worksheetId, worksheetsDtoMapper.toDomain(worksheetsDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Atividade atualizada");
        response.put("Worksheet data: ", worksheetsDtoMapper.toDto(worksheets));

        Backlog backlog = new Backlog(null, userId, "Atualizou o atividade: " + worksheets.id(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/answer/${name}/${userId}")
    public void answerQuestion(@RequestBody WorksheetsDto worksheetsDto, @PathVariable String name, @PathVariable String userId){
        String text = answerUsecase.execute(worksheetsDtoMapper.toDomain(worksheetsDto));

        createUserReportUsecase.execute(userId, name ,text);
    }
}
