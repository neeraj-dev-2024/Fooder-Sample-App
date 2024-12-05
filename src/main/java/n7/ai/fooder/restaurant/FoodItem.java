package n7.ai.fooder.restaurant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record FoodItem(
        @Id
        Integer id,
        String name,
        Float price,
        Integer calories,
        @Version
        Integer version
) {
}
