package n7.ai.fooder;
import n7.ai.fooder.restaurant.Restaurant;
import n7.ai.fooder.restaurant.RestaurantRepository;
import n7.ai.fooder.restaurant.RestaurantType;
import n7.ai.fooder.user.User;
import n7.ai.fooder.user.UserHTTPClient;
import n7.ai.fooder.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("Application Started");
	}
}

