package languages.murasaki.MurasakiLanguages.core.usecases.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;

public interface CreateBacklogUsecase {

    Backlog execute(Backlog backlog);
}
