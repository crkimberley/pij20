import com.sun.glass.ui.SystemClipboard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by chris on 13/12/2016.
 */
public class WordExercise {
    public static void main(String[] args) {
        new WordExercise().launch();
    }

    private void launch() {
        List<String> words = Arrays.asList
                ("zoe", "melissa", "ellie", "lisa", "elizabeth", "sarah", "beth", "alison", "emma");
        System.out.println(words);
        System.out.println();

        words.stream().forEach(w -> System.out.println("  " + w));
        System.out.println();
        words.stream().forEach(System.out::println);
        System.out.println();

        List<String> excitingWords = words
                .stream()
                .map(w -> w + "!")
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        List<String> eyeWords = words
                .stream()
                .map(w -> w.replace("i", "eye"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        List<String> upperCaseWords = words
                .stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        List<String> shortWords = words
                .stream()
                .filter(w -> w.length() < 4)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        List<String> wordsWithB = words
                .stream()
                .filter(w -> w.contains("b"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        List<String> evenLengthWords = words
                .stream()
                .filter(w -> w.length() % 2 == 0)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

        String ex7A = words
                .stream()
                .map(String::toUpperCase)
                .filter(w -> w.length() < 4)
                .filter(w -> w.contains("E"))
                .findFirst()
                .orElse("not found");
        System.out.println(ex7A);

        System.out.println();

        ex7A = words
                .stream()
                .map(String::toUpperCase)
                .filter(w -> w.length() < 4)
                .filter(w -> w.contains("Q"))
                .findFirst()
                .orElse("not found");
        System.out.println(ex7A);

        System.out.println();

        // Using static method so as not to repeat code
        ex7A = upperShortFirstContainsLetter(words, "E");
        System.out.println(ex7A);
        ex7A = upperShortFirstContainsLetter(words, "Q");
        System.out.println(ex7A);

        System.out.println();

        // Using peek to verify lazy evaluation is taking place
        ex7A = words
                .stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(w -> w.length() < 6)
                .filter(w -> w.contains("E"))
                .findAny()
                .orElse("not found");
        System.out.println("ex7A result is " + ex7A);

        System.out.println();

        String concatUpper = words
                .stream()
                .reduce("", (x, y) -> (x + y).toUpperCase());
        System.out.println(concatUpper);

        System.out.println();

        concatUpper = words
                .stream()
                .map(String::toUpperCase)
                .reduce("", String::concat);
        System.out.println(concatUpper);

        System.out.println();

        concatUpper = words
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println(concatUpper);

        System.out.println();

        System.out.println(randomNumberList(5));

        System.out.println();

        System.out.println(orderedNumberList(31, 7, 12));
    }

    private static String upperShortFirstContainsLetter(List<String> words, String letter) {
        return words
                .stream()
                .map(String::toUpperCase)
                .filter(w -> w.length() < 4)
                .filter(w -> w.contains(letter))
                .findFirst()
                .orElse("not found");
    }

    private static List<Double> randomNumberList(long size) {
        return Stream.generate(Math::random)
                .limit(size)
                .collect(Collectors.toList());
    }

    private static List<Integer> orderedNumberList(int initialValue, int stepSize, int size) {
        return Stream.iterate(initialValue, n -> n + stepSize)
                .limit(size)
                .collect(Collectors.toList());
    }
}