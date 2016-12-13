import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chris on 13/12/2016.
 */
public class DishExercise {
    public static void main(String[] args) {
        new DishExercise().launch();
    }

    private void launch() {
        List<Dish> twoMeat = Dish.menu
                .stream()
                .filter((Dish dish) -> dish.getType() == Dish.Type.MEAT)
                .limit(2).collect(Collectors.toList());
        System.out.println(twoMeat);

        long numberOfDishes = Dish.menu
                .stream()
                .count();
        System.out.println("numberOfDishes using count = " + numberOfDishes);

        numberOfDishes = Dish.menu
                .stream()
                .map(dish -> 1)
                .reduce(0, (x,y) -> x + y);
        System.out.println("numberOfDishes using map & reduce = " + numberOfDishes);
    }
}
