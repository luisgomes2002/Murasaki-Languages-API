package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.gateway.BacklogGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.backlog.BacklogEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.backlog.BacklogEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.backlog.BacklogRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BacklogRepositoryGateway implements BacklogGateway {

    private final BacklogRepository backlogRepository;
    private final BacklogEntityMapper backlogEntityMapper;

    public BacklogRepositoryGateway(BacklogRepository backlogRepository, BacklogEntityMapper backlogEntityMapper) {
        this.backlogRepository = backlogRepository;
        this.backlogEntityMapper = backlogEntityMapper;
    }

    @Override
    public Backlog createBacklog(Backlog backlog) {
        BacklogEntity entity = backlogEntityMapper.toEntity(backlog);
        entity.setCreatedAt(LocalDateTime.now());
        BacklogEntity savedEntity = backlogRepository.save(entity);
        return backlogEntityMapper.toDomain(savedEntity);
    }
}
