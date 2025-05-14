package languages.murasaki.MurasakiLanguages.infra.presentation;


import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.usecases.aireport.CreateAiReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.aireport.GetAllAiReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.userreport.GetReportByIdUsecase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ai-report/")
public class AiReportController {

    private final CreateAiReportUsecase createAiReportUsecase;
    private final GetAllAiReportUsecase getAllAiReportUsecase;
    private final GetReportByIdUsecase getReportByIdUsecase;

    public AiReportController(CreateAiReportUsecase createAiReportUsecase, GetAllAiReportUsecase getAllAiReportUsecase, GetReportByIdUsecase getReportByIdUsecase) {
        this.createAiReportUsecase = createAiReportUsecase;
        this.getAllAiReportUsecase = getAllAiReportUsecase;
        this.getReportByIdUsecase = getReportByIdUsecase;
    }

    @PostMapping("/create-ai-report/{userId}")
    public void createAiReport(@PathVariable String userId, @RequestBody String userReportId){
        System.out.println("UserId: " + userId);
        System.out.println("ReportId: " + userReportId);
        UserReport report = getReportByIdUsecase.execute(userReportId);
        createAiReportUsecase.execute(userId, report);
    }

    @GetMapping("/{userId}/")
    public List<AiReport> getAllAiReport(@PathVariable String userId){ return getAllAiReportUsecase.execute(userId); }
}
