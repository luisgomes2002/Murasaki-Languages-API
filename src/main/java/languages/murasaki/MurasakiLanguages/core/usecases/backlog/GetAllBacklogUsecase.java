package languages.murasaki.MurasakiLanguages.core.usecases.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;

import java.util.List;

public interface GetAllBacklogUsecase {

    List<Backlog> execute(int page, int size);
}
