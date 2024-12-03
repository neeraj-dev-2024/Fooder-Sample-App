package n7.ai.fooder;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage() {
        return "Welcome to Spring Boot Application!";
    }
}
