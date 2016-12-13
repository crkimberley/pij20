import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chris on 13/12/2016.
 */
public class NumberExercise {
    public static void main(String[] args) {
        new NumberExercise().launch();
    }

    private void launch() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(3,4);
        System.out.println(numbers);
        System.out.println(numbers2);

        System.out.println("\nsquares");
        List<Integer> squares = numbers
                .parallelStream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(squares);

        System.out.println("\npairs");
        List<int[]> pairs = numbers
                .parallelStream()
                .flatMap(x -> numbers2
                        .parallelStream()
                        .map(y -> new int[] {x,y}))
                .peek(p -> System.out.println(p[0] + "," + p[1]))
                .collect(Collectors.toList());

        System.out.println("\npairs whose sum is divisible by 3");
        pairs = numbers
                .parallelStream()
                .flatMap(x -> numbers2
                        .parallelStream()
                        .filter(y -> (x + y) % 3 == 0)
                        .map(y -> new int[] {x,y}))
                .peek(p -> System.out.println(p[0] + "," + p[1]))
                .collect(Collectors.toList());
    }
}