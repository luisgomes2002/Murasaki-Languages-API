package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.usecases.generatetoken.DeleteTokenUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.generatetoken.GetUserIdByTokenUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.UpdateUserEnableUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mail/")
public class EmailController {

    private final GetUserIdByTokenUsecase getUserIdByTokenUsecase;
    private final DeleteTokenUsecase deleteTokenUsecase;
    private final UpdateUserEnableUsecase updateUserEnableUsecase;

    public EmailController(GetUserIdByTokenUsecase getUserIdByTokenUsecase, DeleteTokenUsecase deleteTokenUsecase, UpdateUserEnableUsecase updateUserEnableUsecase) {
        this.getUserIdByTokenUsecase = getUserIdByTokenUsecase;
        this.deleteTokenUsecase = deleteTokenUsecase;
        this.updateUserEnableUsecase = updateUserEnableUsecase;
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirmEmail(@RequestParam String token) {
        String userId = getUserIdByTokenUsecase.execute(token);

        if (userId == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido ou expirado.");

        updateUserEnableUsecase.execute(userId, true);

        deleteTokenUsecase.execute(token);

        return ResponseEntity.ok("E-mail confirmado com sucesso!");
    }

}
