package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Function<Integer[], Integer> max = arr -> Arrays.stream(arr).sorted().findFirst().orElse(0);
        System.out.println(
                max.apply(
                        Arrays.stream(scan.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .toArray(Integer[]::new)));
    }
}
