package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;

import java.util.List;

public interface BacklogGateway {

    public Backlog createBacklog(Backlog backlog);
    public Pagination<Backlog> getAllBacklog(int page, int size);
}
