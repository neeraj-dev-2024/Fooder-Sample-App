package n7.ai.fooder;
import n7.ai.fooder.run.Run;
import  n7.ai.fooder.run.Location;
import n7.ai.fooder.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("Application Started");
	}

//	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
//		return args -> {
//			Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
//			runRepository.create(run);
//		};
//	}
}
