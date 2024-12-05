package n7.ai.fooder.restaurant;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException() {
        super("Restaurant Not Found");
    }
}
