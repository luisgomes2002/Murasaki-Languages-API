package languages.murasaki.MurasakiLanguages.infra.mapper.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.Metrics;
import languages.murasaki.MurasakiLanguages.infra.persistence.metrics.MetricsEntity;
import org.springframework.stereotype.Component;

@Component
public class MetricsEntityMapper {

    public MetricsEntity toEntity(Metrics metrics){
        return new MetricsEntity(
            metrics.id(),
            metrics.date(),
            metrics.totalUsers(),
            metrics.activeUsers(),
            metrics.bannedUsers(),
            metrics.deletedUsers(),
            metrics.userAgeDistribution(),
            metrics.topLanguages(),
            metrics.topGender()
        );
    }

    public Metrics toDomain(MetricsEntity metricsEntity){
        return new Metrics(
            metricsEntity.getId(),
            metricsEntity.getDate(),
            metricsEntity.getTotalUsers(),
            metricsEntity.getActiveUsers(),
            metricsEntity.getBannedUsers(),
            metricsEntity.getDeletedUsers(),
            metricsEntity.getUserAgeDistribution(),
            metricsEntity.getTopLanguages(),
            metricsEntity.getTopGender()
        );
    }
}
