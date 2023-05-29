package slowboat.slowboat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SlowboatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowboatApplication.class, args);
	}

}
