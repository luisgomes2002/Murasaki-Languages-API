package languages.murasaki.MurasakiLanguages.infra.mapper.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.infra.persistence.backlog.BacklogEntity;
import org.springframework.stereotype.Component;

@Component
public class BacklogEntityMapper {

    public BacklogEntity toEntity(Backlog backlog){
        return new BacklogEntity(
            backlog.id(),
            backlog.user(),
            backlog.description(),
            backlog.createdAt()
        );
    }

    public Backlog toDomain(BacklogEntity backlogEntity){
        return new Backlog(
            backlogEntity.getId(),
            backlogEntity.getUser(),
            backlogEntity.getDescription(),
            backlogEntity.getCreatedAt()
        );
    }
}
