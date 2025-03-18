package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.usecases.user.CreateUserUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.LoginUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.LoginDto;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.UserDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.LoginDtoMapper;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.UserDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user/")
public class UserController {

    private final CreateUserUsecase createUserUsecase;
    private final LoginUsecase loginUsecase;
    private final UserDtoMapper userDtoMapper;
    private final LoginDtoMapper loginDtoMapper;

    public UserController(CreateUserUsecase createUserUsecase, LoginUsecase loginUsecase, UserDtoMapper userDtoMapper, LoginDtoMapper loginDtoMapper) {
        this.createUserUsecase = createUserUsecase;
        this.loginUsecase = loginUsecase;
        this.userDtoMapper = userDtoMapper;
        this.loginDtoMapper = loginDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto){
        User newUser = createUserUsecase.execute(userDtoMapper.toDomain(userDto));
        Map<String, Object > response = new HashMap<>();
        response.put("Message:", "Usuário criado com sucesso.");
        response.put("User data:", userDtoMapper.toDto(newUser));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String token = loginUsecase.execute(loginDtoMapper.toDomain(loginDto));
        return ResponseEntity.ok(token);
    }


}
