package languages.murasaki.MurasakiLanguages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MurasakiLanguagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MurasakiLanguagesApplication.class, args);
	}

}
