package languages.murasaki.MurasakiLanguages.infra.mapper.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.infra.dtos.plans.PlansDto;
import org.springframework.stereotype.Component;

@Component
public class PlansDtoMapper {

    public PlansDto toDto(Plans plans){
       return new PlansDto(
           plans.id(),
           plans.planId(),
           plans.title(),
           plans.description(),
           plans.value(),
           plans.advantages()
       );
    }

    public Plans toDomain(PlansDto plansDto){
        return new Plans(
            plansDto.id(),
            plansDto.planId(),
            plansDto.title(),
            plansDto.description(),
            plansDto.value(),
            plansDto.advantages()
        );
    }
}
