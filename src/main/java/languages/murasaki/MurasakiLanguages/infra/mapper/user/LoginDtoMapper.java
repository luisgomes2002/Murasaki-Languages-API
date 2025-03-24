package languages.murasaki.MurasakiLanguages.infra.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.LoginDto;
import org.springframework.stereotype.Component;

@Component
public class LoginDtoMapper {

    public LoginDto toDto(Login login){
        return new LoginDto(
                login.email(),
                login.password()
        );
    }

    public Login toDomain(LoginDto loginDto){
        return new Login(
                loginDto.email(),
                loginDto.password()
        );
    }
}
