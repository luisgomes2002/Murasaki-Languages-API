package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.GetAllBacklogUsecase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/backlog/")
public class BacklogController {

    private final GetAllBacklogUsecase getAllBacklogUsecase;

    public BacklogController(GetAllBacklogUsecase getAllBacklogUsecase) {
        this.getAllBacklogUsecase = getAllBacklogUsecase;
    }

    @GetMapping("/")
    public List<Backlog> getAllBacklog(){
        return getAllBacklogUsecase.execute();
    }

}
