package languages.murasaki.MurasakiLanguages.infra.mapper.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.infra.persistence.plans.PlansEntity;
import org.springframework.stereotype.Component;

@Component
public class PlansEntityMapper {

    public PlansEntity toEntity(Plans plans){
        return new PlansEntity(
            plans.id(),
            plans.title(),
            plans.description(),
            plans.value(),
            plans.advantages(),
            plans.link()
        );
    }

    public Plans toDomain(PlansEntity plansEntity){
        return new Plans(
            plansEntity.getId(),
            plansEntity.getTitle(),
            plansEntity.getDescription(),
            plansEntity.getValue(),
            plansEntity.getAdvantages(),
            plansEntity.getLink()
        );
    }
}
