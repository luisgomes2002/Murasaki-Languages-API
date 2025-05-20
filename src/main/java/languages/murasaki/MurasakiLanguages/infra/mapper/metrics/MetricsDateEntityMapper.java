package languages.murasaki.MurasakiLanguages.infra.mapper.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsDate;
import languages.murasaki.MurasakiLanguages.infra.persistence.metrics.MetricsDateEntity;
import org.springframework.stereotype.Component;

@Component
public class MetricsDateEntityMapper {

    public MetricsDateEntity toEntity(MetricsDate metricsDate){
        return new MetricsDateEntity(
            metricsDate.id(),
            metricsDate.dateTimes()
        );
    }

    public MetricsDate toDomain(MetricsDateEntity metricsDateEntity){
        return new MetricsDate(
            metricsDateEntity.getId(),
            metricsDateEntity.getDateTimes()
        );
    }
}
