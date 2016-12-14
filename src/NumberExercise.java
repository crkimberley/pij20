import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
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
        List<Integer> numbers3 = Arrays.asList(31,23,19,57,41,68);
        List<Double> numbers4 = Arrays.asList(237.517,356.248,4123.1907,876.739);
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

        System.out.println("\n" + numbers3);
        int sum = numbers3
                .parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        System.out.println("\n" + numbers3);
        sum = numbers3
                .parallelStream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum = " + sum);

        System.out.println("\n" + numbers3);
        sum = numbers3
                .parallelStream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("sum = " + sum);

        System.out.println("\n" + numbers4);
        double product = numbers4
                .stream()
                .reduce((x,y) -> x * y)
                .get();
        System.out.println("product = " + product);
        product = numbers4
                .parallelStream()
                .reduce((x,y) -> x * y)
                .get();
        System.out.println("product = " + product + " parallel");
    }
}