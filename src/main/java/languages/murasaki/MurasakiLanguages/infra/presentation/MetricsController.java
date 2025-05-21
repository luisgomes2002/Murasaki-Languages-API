package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.Metrics;
import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsDate;
import languages.murasaki.MurasakiLanguages.core.usecases.metrics.AddMetricsToListUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.metrics.GetAllMetricsDateUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.metrics.GetMetricByDateUsecase;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/metrics/")
public class MetricsController {

    private final GetMetricByDateUsecase getMetricByDateUsecase;
    private final AddMetricsToListUsecase addMetricsToListUsecase;
    private final GetAllMetricsDateUsecase getAllMetricsDateUsecase;

    public MetricsController(GetMetricByDateUsecase getMetricByDateUsecase, AddMetricsToListUsecase addMetricsToListUsecase, GetAllMetricsDateUsecase getAllMetricsDateUsecase) {
        this.getMetricByDateUsecase = getMetricByDateUsecase;
        this.addMetricsToListUsecase = addMetricsToListUsecase;
        this.getAllMetricsDateUsecase = getAllMetricsDateUsecase;
    }


    @GetMapping("/")
    public Metrics getMetricByDate(@RequestParam String date){
        return getMetricByDateUsecase.execute(date);
    }

    @PostMapping("/add")
    public void addDateToList(@RequestParam LocalDate date){
        addMetricsToListUsecase.execute(date);
    }

    @GetMapping("/metrics-date/")
    public List<MetricsDate> getAllMetricsDate(){
        return getAllMetricsDateUsecase.execute();
    }
}
