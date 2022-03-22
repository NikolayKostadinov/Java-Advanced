package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Integer[] delimiters = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Predicate<Integer> filterDelimiters =
                y -> Arrays.stream(delimiters).allMatch(x -> y % x == 0);

        System.out.println(IntStream.range(1, n + 1)
                .boxed()
                .filter(filterDelimiters)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
