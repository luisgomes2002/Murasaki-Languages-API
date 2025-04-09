package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.core.gateway.ExplanationGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.lesson.ExplanationEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.ExplanationEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.lesson.ExplanationRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExplanationRepositoryGateway implements ExplanationGateway {

    private final ExplanationRepository explanationRepository;
    private final ExplanationEntityMapper explanationEntityMapper;

    public ExplanationRepositoryGateway(ExplanationRepository explanationRepository, ExplanationEntityMapper explanationEntityMapper) {
        this.explanationRepository = explanationRepository;
        this.explanationEntityMapper = explanationEntityMapper;
    }

    @Override
    public Explanation createExplanation(Explanation explanation) {
        ExplanationEntity entity = explanationEntityMapper.toEntity(explanation);
        explanationRepository.save(entity);
        return explanationEntityMapper.toDomain(entity);
    }

    @Override
    public Explanation updateExplanation(String id, Explanation explanation) {
        Optional<ExplanationEntity> entity = explanationRepository.findById(id);

        if(entity.isPresent()){
            ExplanationEntity updatedExplanation = entity.get();

            updatedExplanation.setPhrase(explanation.phrase());
            updatedExplanation.setTranslation(explanation.translation());
            updatedExplanation.setExplanation(explanation.explanation());

            explanationRepository.save(updatedExplanation);

            return explanationEntityMapper.toDomain(updatedExplanation);
        }

        return null;
    }

    @Override
    @Cacheable(value = "lesson", key = "#id")
    public Explanation getExplanationById(String id) {
        return explanationRepository.findById(id).map(explanationEntityMapper::toDomain).orElse(null);
    }

    @Override
    public void deleteExplanation(String id) {
        explanationRepository.deleteById(id);
    }
}
