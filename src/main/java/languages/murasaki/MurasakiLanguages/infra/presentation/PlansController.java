package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.plans.CreatePlanUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.plans.PlansDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.plans.PlansDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/plans/")
public class PlansController {

    private final CreatePlanUsecase createPlanUsecase;
    private final PlansDtoMapper plansDtoMapper;
    private final CreateBacklogUsecase createBacklogUsecase;

    public PlansController(CreatePlanUsecase createPlanUsecase, PlansDtoMapper plansDtoMapper, CreateBacklogUsecase createBacklogUsecase) {
        this.createPlanUsecase = createPlanUsecase;
        this.plansDtoMapper = plansDtoMapper;
        this.createBacklogUsecase = createBacklogUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createPlan(@RequestBody PlansDto plansDto, String userId){
        Plans plans = createPlanUsecase.execute(plansDtoMapper.toDomain(plansDto));
        Map<String, Object> resopnse = new HashMap<>();
        resopnse.put("Message: ", "Plano criado.");
        resopnse.put("Plan data: ", plansDtoMapper.toDto(plans));

        Backlog backlog = new Backlog(null, userId, "Criou um plano: " + plans.title(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.CREATED).body(resopnse);
    }
}
