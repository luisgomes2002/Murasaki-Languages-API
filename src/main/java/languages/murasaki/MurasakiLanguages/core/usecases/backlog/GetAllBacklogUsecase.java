package languages.murasaki.MurasakiLanguages.core.usecases.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;

import java.util.List;

public interface GetAllBacklogUsecase {

    Pagination<Backlog> execute(int page, int size);
}
