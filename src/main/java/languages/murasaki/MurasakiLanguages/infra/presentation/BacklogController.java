package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.GetAllBacklogUsecase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/backlog/")
public class BacklogController {

    private final GetAllBacklogUsecase getAllBacklogUsecase;

    public BacklogController(GetAllBacklogUsecase getAllBacklogUsecase) {
        this.getAllBacklogUsecase = getAllBacklogUsecase;
    }

    @GetMapping("/")
    public List<Backlog> getAllBacklog(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return getAllBacklogUsecase.execute(page, size);
    }

}
