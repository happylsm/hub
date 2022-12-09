package hubSideProject.hubApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HubApiApplication.class, args);
	}

}
