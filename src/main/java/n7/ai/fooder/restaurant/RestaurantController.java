package n7.ai.fooder.restaurant;

import jakarta.validation.Valid;
import n7.ai.fooder.Application;
import n7.ai.fooder.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantRepository repository;
    private final RestaurantFoodItemRepository restaurantFoodItemRepository;
    private final FoodItemRepository foodItemRepository;

    public RestaurantController(RestaurantRepository repository, RestaurantFoodItemRepository restaurantFoodItemRepository, FoodItemRepository foodItemRepository) {
        this.repository = repository;
        this.restaurantFoodItemRepository = restaurantFoodItemRepository;
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping("health")
    @ResponseStatus(HttpStatus.OK)
    String health() {
        return "OK";
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Restaurant restaurant) {
        repository.save(restaurant);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add_food_item/{restaurantId}/{foodItemID}")
    void addFoodItemToRestaurant(@PathVariable Integer restaurantId, @PathVariable Integer foodItemID) {
        restaurantFoodItemRepository.save(new RestaurantFoodItem(null, restaurantId, foodItemID, null));
    }

    @GetMapping("/get_details/{restaurantId}")
    public RestaurantDetailsDTO getRestaurantWithFoodItems(@PathVariable Integer restaurantId) {
        log.info("getRestaurantWithFoodItems: {}", restaurantId);

        // Fetch the restaurant details
        Restaurant restaurant = repository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));

        // Fetch the food item mappings
        List<RestaurantFoodItem> mappings = restaurantFoodItemRepository.findAllByRestaurantId(restaurantId);
        log.info("Mappings: {}", mappings);

        // Fetch the associated food items
        List<FoodItem> foodItems = mappings.stream()
                .map(mapping -> foodItemRepository.findById(mapping.foodItemId())
                        .orElseThrow(() -> new RuntimeException("Food item not found with ID: " + mapping.foodItemId())))
                .toList();

        // Combine restaurant and food items into a DTO
        return new RestaurantDetailsDTO(restaurant, foodItems);
    }
}
