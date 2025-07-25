package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;
import languages.murasaki.MurasakiLanguages.core.gateway.BacklogGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.backlog.BacklogEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.backlog.BacklogEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.backlog.BacklogRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    @Cacheable(value = "all-backlogs")
    public Pagination<Backlog> getAllBacklog(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var pageResult = backlogRepository.findAll(pageable);

        var content = pageResult.getContent()
                .stream()
                .map(backlogEntityMapper::toDomain)
                .toList();

        return new Pagination<>(
                content,
                pageResult.getTotalPages(),
                pageResult.getTotalElements(),
                pageResult.getSize(),
                pageResult.getNumber()
        );
    }


}
