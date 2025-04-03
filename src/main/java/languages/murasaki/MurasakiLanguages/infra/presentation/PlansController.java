package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.plans.*;
import languages.murasaki.MurasakiLanguages.core.usecases.user.UpdateUserUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.plans.PlansDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.plans.PlansDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/plans/")
public class PlansController {

    private final CreatePlanUsecase createPlanUsecase;
    private final PlansDtoMapper plansDtoMapper;
    private final CreateBacklogUsecase createBacklogUsecase;
    private final DeletePlanUsecase deletePlanUsecase;
    private final GetAllPlansUsecase getAllPlansUsecase;
    private final GetPlanByIdUsecase getPlanByIdUsecase;
    private final UpdatePlanUsecase updatePlanUsecase;

    public PlansController(CreatePlanUsecase createPlanUsecase, PlansDtoMapper plansDtoMapper, CreateBacklogUsecase createBacklogUsecase, DeletePlanUsecase deletePlanUsecase, GetAllPlansUsecase getAllPlansUsecase, GetPlanByIdUsecase getPlanByIdUsecase, UpdatePlanUsecase updatePlanUsecase) {
        this.createPlanUsecase = createPlanUsecase;
        this.plansDtoMapper = plansDtoMapper;
        this.createBacklogUsecase = createBacklogUsecase;
        this.deletePlanUsecase = deletePlanUsecase;
        this.getAllPlansUsecase = getAllPlansUsecase;
        this.getPlanByIdUsecase = getPlanByIdUsecase;
        this.updatePlanUsecase = updatePlanUsecase;
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

    @GetMapping("/")
    public List<Plans> getAllPlans(){ return getAllPlansUsecase.execute();}

    @GetMapping("list/{id}")
    public Plans getPlanById(@PathVariable String id){
        return getPlanByIdUsecase.execute(id);
    }

    @PutMapping("update/{planId}")
    public ResponseEntity<Map<String, Object>> updatePlan(@PathVariable String planId, @RequestBody PlansDto plansDto, String userId){
        Plans plans = updatePlanUsecase.execute(planId, plansDtoMapper.toDomain(plansDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Plano atualizado");
        response.put("Plan data: ", plansDtoMapper.toDto(plans));

        Backlog backlog = new Backlog(null, userId, "Atualizou o plano: " + plans.title(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("delete/{planId}")
    public String deletePlan(@PathVariable String planId, String userId){
        deletePlanUsecase.execute(planId);

        Backlog backlog = new Backlog(null, userId, "Excluiu o plano: " + planId, null);
        createBacklogUsecase.execute(backlog);

        return "Plando excluido";
    }
}
