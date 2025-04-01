package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.plans.PlansEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.plans.PlansEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.plans.PlansRepository;
import org.springframework.stereotype.Component;

@Component
public class PlansRepositoryGateway implements PlansGateway {

    private final PlansRepository plansRepository;
    private final PlansEntityMapper plansEntityMapper;

    public PlansRepositoryGateway(PlansRepository plansRepository, PlansEntityMapper plansEntityMapper) {
        this.plansRepository = plansRepository;
        this.plansEntityMapper = plansEntityMapper;
    }

    @Override
    public Plans createPlan(Plans plans) {
        PlansEntity entity = plansEntityMapper.toEntity(plans);
        PlansEntity newPlan = plansRepository.save(entity);
        return plansEntityMapper.toDomain(newPlan);
    }
}
