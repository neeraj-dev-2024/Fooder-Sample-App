package n7.ai.fooder.restaurant;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/foodItems")
public class FoodItemController {

    private final FoodItemRepository repository;

    public FoodItemController(FoodItemRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody FoodItem food_item) {
        repository.save(food_item);
    }
}
