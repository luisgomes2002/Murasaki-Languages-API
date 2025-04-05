package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.report.CreateReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.report.GetAllReportsUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.report.UpdateReportStatusUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.report.ReportDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.report.ReportDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/report/")
public class ReportController {

    private final CreateReportUsecase createReportUsecase;
    private final ReportDtoMapper reportDtoMapper;
    private final GetAllReportsUsecase getAllReportsUsecase;
    private final UpdateReportStatusUsecase updateReportStatusUsecase;
    private final CreateBacklogUsecase createBacklogUsecase;

    public ReportController(CreateReportUsecase createReportUsecase, ReportDtoMapper reportDtoMapper, GetAllReportsUsecase getAllReportsUsecase, UpdateReportStatusUsecase updateReportStatusUsecase, CreateBacklogUsecase createBacklogUsecase) {
        this.createReportUsecase = createReportUsecase;
        this.reportDtoMapper = reportDtoMapper;
        this.getAllReportsUsecase = getAllReportsUsecase;
        this.updateReportStatusUsecase = updateReportStatusUsecase;
        this.createBacklogUsecase = createBacklogUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createReport(@RequestBody ReportDto reportDto){
        Report newReport = createReportUsecase.execute(reportDtoMapper.toDomain(reportDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Reporte criado");
        response.put("Report data", reportDtoMapper.toDto(newReport));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<Report> getAllReports(){
        return getAllReportsUsecase.execute();
    }

    // TODO: mudar o id para pegar pelo body
    @PutMapping("update-status/{id}")
    public String updateReportStatus(@PathVariable String id, @RequestBody boolean finished,  String loggedUser){
        updateReportStatusUsecase.execute(id, finished);

        Backlog backlog = new Backlog(null, loggedUser, "Atualizou o status do report: " + id + " para " + finished, null);
        createBacklogUsecase.execute(backlog);

        return "Status atualizado para: " + finished;
    }


}
