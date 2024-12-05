package n7.ai.fooder.restaurant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record RestaurantFoodItem(
        @Id
        Integer id,
        Integer restaurantId,
        Integer foodItemId,
        @Version
        Integer version
) {
}
