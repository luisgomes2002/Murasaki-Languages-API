package languages.murasaki.MurasakiLanguages.infra.mapper.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.infra.dtos.backlog.BacklogDto;
import org.springframework.stereotype.Component;

@Component
public class BacklogDtoMapper {

    public BacklogDto toDto(Backlog backlog){
        return new BacklogDto(
            backlog.id(),
            backlog.user(),
            backlog.description(),
            backlog.createdAt()
        );
    }

    public Backlog toDomain(BacklogDto backlogDto){
        return new Backlog(
            backlogDto.id(),
            backlogDto.user(),
            backlogDto.description(),
            backlogDto.createdAt()
        );
    }
}
