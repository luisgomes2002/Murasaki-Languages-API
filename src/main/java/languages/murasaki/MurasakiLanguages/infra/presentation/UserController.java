package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.User;
import languages.murasaki.MurasakiLanguages.core.usecases.user.CreateUserUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.UserDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.UserDtoMapper;
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
    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserUsecase createUserUsecase, UserDtoMapper userDtoMapper) {
        this.createUserUsecase = createUserUsecase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto){
        User newUser = createUserUsecase.execute(userDtoMapper.toDomain(userDto));
        Map<String, Object > response = new HashMap<>();
        response.put("Message:", "Usuário criado com sucesso.");
        response.put("User data:", userDtoMapper.toDto(newUser));
        return ResponseEntity.ok(response);
    }


}
