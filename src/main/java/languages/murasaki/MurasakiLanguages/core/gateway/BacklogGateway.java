package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;

import java.util.List;

public interface BacklogGateway {

    public Backlog createBacklog(Backlog backlog);
    public List<Backlog> getAllBacklog();
}
