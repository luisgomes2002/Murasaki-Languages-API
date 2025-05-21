package languages.murasaki.MurasakiLanguages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableCaching
public class MurasakiLanguagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MurasakiLanguagesApplication.class, args);
	}

}
