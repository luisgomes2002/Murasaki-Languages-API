package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.usecases.user.CreateUserUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.GetAllUsersUseCase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.LoginUsecase;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.LoginDto;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.UserDto;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.response.LoginResponseDto;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.LoginDtoMapper;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.UserDtoMapper;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.response.UserResponseDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user/")
public class UserController {

    private final CreateUserUsecase createUserUsecase;
    private final LoginUsecase loginUsecase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final UserDtoMapper userDtoMapper;
    private final LoginDtoMapper loginDtoMapper;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public UserController(CreateUserUsecase createUserUsecase, LoginUsecase loginUsecase, GetAllUsersUseCase getAllUsersUseCase, UserDtoMapper userDtoMapper, LoginDtoMapper loginDtoMapper, UserResponseDtoMapper userResponseDtoMapper) {
        this.createUserUsecase = createUserUsecase;
        this.loginUsecase = loginUsecase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.userDtoMapper = userDtoMapper;
        this.loginDtoMapper = loginDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto){
        User newUser = createUserUsecase.execute(userDtoMapper.toDomain(userDto));
        Map<String, Object > response = new HashMap<>();
        response.put("Message: ", "Usuário criado com sucesso.");
        response.put("User data: ", userResponseDtoMapper.toDto(newUser));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return getAllUsersUseCase.execute();
    }

//    @GetMapping("list/{id}")
//    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String id){
//
//    }
//
//    @PutMapping("update/{id}")
//    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable String id, @RequestBody UserDto userDto){
//
//    }
//
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable String id){
//
//    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto){
        String token = loginUsecase.execute(loginDtoMapper.toDomain(loginDto));
        return ResponseEntity.ok( new LoginResponseDto(token));
    }
}
