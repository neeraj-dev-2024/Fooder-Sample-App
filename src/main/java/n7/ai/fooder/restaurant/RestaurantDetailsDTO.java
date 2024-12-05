package n7.ai.fooder.restaurant;

import java.util.List;

public record RestaurantDetailsDTO(
        Restaurant restaurant,
        List<FoodItem> foodItems
) {
}
