package languages.murasaki.MurasakiLanguages.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateUserException(DuplicateUserException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message:", "Por favor, insira um e-mail válido.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleIdNotFoundException(IdNotFoundException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Por favor, insira um ID válido.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailOrPasswordIncorrectException.class)
    public ResponseEntity<Map<String, String>> handleEmailOrPasswordIncorrectException(EmailOrPasswordIncorrectException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Por favor, insira um email ou senha válida");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingArgumentsException.class)
    public ResponseEntity<Map<String, String>> handleMissingArgumentsException(MissingArgumentsException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Por favor, preencha todos os campos");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoesNotHavePermissionException.class)
    public ResponseEntity<Map<String, String>> handleUserDoesNotHavePermissionException(UserDoesNotHavePermissionException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Usuário não tem permissão para fazer essa ação!");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Update password
}
