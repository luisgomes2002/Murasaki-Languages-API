package languages.murasaki.MurasakiLanguages.core.usecases.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.gateway.BacklogGateway;

public class CreateBacklogUsecaseImpl implements CreateBacklogUsecase{

    private final BacklogGateway backlogGateway;

    public CreateBacklogUsecaseImpl(BacklogGateway backlogGateway) {
        this.backlogGateway = backlogGateway;
    }

    @Override
    public Backlog execute(Backlog backlog) {
        return backlogGateway.createBacklog(backlog);
    }
}
