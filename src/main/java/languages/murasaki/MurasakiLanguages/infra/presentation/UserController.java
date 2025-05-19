package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.email.Email;
import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.email.SendEmailUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.generatetoken.GenerateAndStoreTokenUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.generatetoken.GetUserIdByTokenUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.*;
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
    private final CreateBacklogUsecase createBacklogUsecase;
    private final GetUserByIdUsecase getUserByIdUsecase;
    private final DeleteUserUsecase deleteUserUsecase;
    private final UpdateUserUsecase updateUserUsecase;
    private final UpdateUserPasswordUsecase updateUserPasswordUsecase;
    private final UpdateUserTypeUsecase updateUserTypeUsecase;
    private final UpdateUserEnableUsecase updateUserEnableUsecase;
    private final SendEmailUsecase sendEmailUsecase;
    private final GenerateAndStoreTokenUsecase generateAndStoreTokenUsecase;
    private final GetUserIdByTokenUsecase getUserIdByTokenUsecase;

    public UserController(CreateUserUsecase createUserUsecase, LoginUsecase loginUsecase, GetAllUsersUseCase getAllUsersUseCase, UserDtoMapper userDtoMapper, LoginDtoMapper loginDtoMapper, UserResponseDtoMapper userResponseDtoMapper, CreateBacklogUsecase createBacklogUsecase, GetUserByIdUsecase getUserByIdUsecase, DeleteUserUsecase deleteUserUsecase, UpdateUserUsecase updateUserUsecase, UpdateUserPasswordUsecase updateUserPasswordUsecase, UpdateUserTypeUsecase updateUserTypeUsecase, UpdateUserEnableUsecase updateUserEnableUsecase, SendEmailUsecase sendEmailUsecase, GenerateAndStoreTokenUsecase generateAndStoreTokenUsecase, GetUserIdByTokenUsecase getUserIdByTokenUsecase) {
        this.createUserUsecase = createUserUsecase;
        this.loginUsecase = loginUsecase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.userDtoMapper = userDtoMapper;
        this.loginDtoMapper = loginDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.createBacklogUsecase = createBacklogUsecase;
        this.getUserByIdUsecase = getUserByIdUsecase;
        this.deleteUserUsecase = deleteUserUsecase;
        this.updateUserUsecase = updateUserUsecase;
        this.updateUserPasswordUsecase = updateUserPasswordUsecase;
        this.updateUserTypeUsecase = updateUserTypeUsecase;
        this.updateUserEnableUsecase = updateUserEnableUsecase;
        this.sendEmailUsecase = sendEmailUsecase;
        this.generateAndStoreTokenUsecase = generateAndStoreTokenUsecase;
        this.getUserIdByTokenUsecase = getUserIdByTokenUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto){
        User newUser = createUserUsecase.execute(userDtoMapper.toDomain(userDto));
        Map<String, Object > response = new HashMap<>();
        response.put("Message: ", "Usuário criado com sucesso.");

        Backlog backlog = new Backlog(null, newUser.id(),newUser.name() + " criou uma conta", null);
        createBacklogUsecase.execute(backlog);

        String token = generateAndStoreTokenUsecase.execute(newUser.id());

        String confirmationLink = "http://localhost:8080/api/confirm?token=" + token;

        Email newEmail = new Email(
                newUser.email(),
                "Confirmação de Cadastro",
                "Olá! Obrigado por se cadastrar. Clique no link abaixo para confirmar seu e-mail:\n" + confirmationLink
        );

        sendEmailUsecase.execute(newEmail);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("send-confirm-email")
    public void SendConfirmEmail(@RequestBody String email){
        String token = generateAndStoreTokenUsecase.execute(email);

        String confirmationLink = "http://localhost:8080/api/confirm?token=" + token;

        Email newEmail = new Email(
                email,
                "Confirmação de Email",
                "Olá! Obrigado por se cadastrar. Clique no link abaixo para confirmar seu e-mail:\n" + confirmationLink
        );

        sendEmailUsecase.execute(newEmail);
    }

    @GetMapping("/")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return getAllUsersUseCase.execute(page, size);
    }

    @GetMapping("list/{id}")
    public User getUserById(@PathVariable String id){
        return getUserByIdUsecase.execute(id);
    }

    @GetMapping("request-password/{userId}/{userEmail}")
    public String requestToChangePassword(@PathVariable String userId, @PathVariable String userEmail){
        String token = generateAndStoreTokenUsecase.execute(userId);

        Email newEmail = new Email(
                userEmail,
                "Confirmação de Atualização de Senha",
                "Olá! Seu pedido para alteração da senha. Se você não fez essa alteração, por favor, clique no link abaixo para redefinir sua senha:\n" + token
        );

        sendEmailUsecase.execute(newEmail);

        return "Email enviado";
    }

    @PutMapping("update/{userID}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable String userID, @RequestBody UserDto userDto, @RequestParam String token){
        String userId = getUserIdByTokenUsecase.execute(token);

        if (userId == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Token inválido ou expirado.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        User user = updateUserUsecase.execute(userID, userDtoMapper.toDomain(userDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Usuário atualizado");
        response.put("User data: ", userResponseDtoMapper.toDto(user));

        Backlog backlog = new Backlog(null, userID,"Atualizou as informações da conta: " + userDto.name(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("update-password/{id}")
    public ResponseEntity<Map<String, Object>> updateUserPassword(@PathVariable String id, @RequestBody String newPassword){
        User user = updateUserPasswordUsecase.execute(id, newPassword);
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Senha atualizado");

        Backlog backlog = new Backlog(null, id, "Atualizou a senha: " + user.name(), null);
        createBacklogUsecase.execute(backlog);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable String id, String userId){
        deleteUserUsecase.execute(id);

        Backlog backlog = new Backlog(null, userId, "Excluiu a conta: " + id, null);
        createBacklogUsecase.execute(backlog);

        return "Conta excluida";
    }

    // TODO: mudar o id para pegar pelo body
    @PutMapping("update-role/{id}")
    public String updateUserRole(@PathVariable String id, @RequestBody UserType userType, String loggedUser){
        updateUserTypeUsecase.execute(id, userType);

        Backlog backlog = new Backlog(null, loggedUser, "Atualizou o cargo da conta: " + id + " para " + userType, null);
        createBacklogUsecase.execute(backlog);

        return "Cargo atualizado para: " + userType;
    }

    // TODO: mudar o id para pegar pelo body
    @PutMapping("update-status/{id}")
    public String updateUserState(@PathVariable String id, @RequestBody boolean isEnable, String loggedUser){
        updateUserEnableUsecase.execute(id, isEnable);

        Backlog backlog = new Backlog(null, loggedUser, "Atualizou o status da conta: " + id + " para " + isEnable, null);
        createBacklogUsecase.execute(backlog);

        return "Status atualizado para: " + isEnable;
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto){
        String token = loginUsecase.execute(loginDtoMapper.toDomain(loginDto));
        return ResponseEntity.ok( new LoginResponseDto(token));
    }
}
