package n7.ai.fooder.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

public interface UserHTTPClient {

    @GetExchange("/users")
    List<User> findAll();

    @GetExchange("/{id}")
    User findById(Integer id);
}
