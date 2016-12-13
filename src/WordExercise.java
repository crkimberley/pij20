import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    static String upperShortFirstContainsLetter(List<String> words, String letter) {
        return words
                .stream()
                .map(String::toUpperCase)
                .filter(w -> w.length() < 4)
                .filter(w -> w.contains(letter))
                .findFirst()
                .orElse("not found");
    }
}