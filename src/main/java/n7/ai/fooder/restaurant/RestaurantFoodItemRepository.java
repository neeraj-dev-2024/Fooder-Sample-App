package n7.ai.fooder.restaurant;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RestaurantFoodItemRepository extends ListCrudRepository<RestaurantFoodItem, Integer> {
    List<RestaurantFoodItem> findAllByRestaurantId(int restaurantId);

}
