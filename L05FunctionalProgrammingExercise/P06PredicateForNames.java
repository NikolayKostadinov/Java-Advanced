package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxLength = Integer.parseInt(scan.nextLine());
        Predicate<String> checkLength = x -> x.length() <= maxLength;
        Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(checkLength)
                .forEach(System.out::println);
    }
}
