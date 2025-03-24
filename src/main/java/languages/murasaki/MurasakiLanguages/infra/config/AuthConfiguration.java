package languages.murasaki.MurasakiLanguages.infra.config;

import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthConfiguration implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha incorreto"));
    }
}
