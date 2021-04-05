package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"service", "repository", "controller"})
@SpringBootApplication
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"repository"})
@EnableScheduling
public class TestingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingSpringbootApplication.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
