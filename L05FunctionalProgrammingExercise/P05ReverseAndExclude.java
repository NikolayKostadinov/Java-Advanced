package L05FunctionalProgrammingExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> storage = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(storage::push);

        int divider = Integer.parseInt(scan.nextLine());

        System.out.println(
                storage.stream()
                        .filter(getFilterPredicate(divider))
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

    private static Predicate<Integer> getFilterPredicate(int divider) {
        return x -> (x % divider) != 0;
    }
}
