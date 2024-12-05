package n7.ai.fooder.restaurant;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Restaurant(
        @Id
        Integer id,
        @NotEmpty
        String name,
        String address,
        RestaurantType type,
        @Version
        Integer version
) {
}
