package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.plans.PlansEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.plans.PlansEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.plans.PlansRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    @Cacheable(value = "all-plans")
    public List<Plans> getAllPlans() {
        return plansRepository.findAll().stream().map(plansEntityMapper::toDomain).toList();
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public Plans getPlanById(String id) {
        return plansRepository.findById(id).map(plansEntityMapper::toDomain).orElse(null);
    }

    @Override
    public Plans updatePlan(String id, Plans plan) {
        Optional<PlansEntity> entity = plansRepository.findById(id);

        if(entity.isPresent()){
            PlansEntity updatedPlan = entity.get();
            updatedPlan.setTitle(plan.title());
            updatedPlan.setDescription(plan.description());
            updatedPlan.setValue(plan.value());
            updatedPlan.setAdvantages(plan.advantages());
            updatedPlan.setLink(plan.link());

            plansRepository.save(updatedPlan);

            return plansEntityMapper.toDomain(updatedPlan);
        }
        return null;
    }

    @Override
    public void deletePlan(String id) {
        plansRepository.deleteById(id);
    }


}
