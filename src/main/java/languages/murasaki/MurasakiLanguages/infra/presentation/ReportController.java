package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.report.CreateReportUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.report.ReportDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.report.ReportDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/report/")
public class ReportController {

    private final CreateReportUsecase createReportUsecase;
    private final ReportDtoMapper reportDtoMapper;

    public ReportController(CreateReportUsecase createReportUsecase, ReportDtoMapper reportDtoMapper) {
        this.createReportUsecase = createReportUsecase;
        this.reportDtoMapper = reportDtoMapper;
    }

    @PostMapping("create/{objectId}")
    public ResponseEntity<Map<String, Object>> createReport(@RequestBody ReportDto reportDto, @PathVariable String objectId){
        Report newReport = createReportUsecase.execute(reportDtoMapper.toDomain(reportDto) ,objectId);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Reporte criado");
        response.put("Report data", reportDtoMapper.toDto(newReport));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
