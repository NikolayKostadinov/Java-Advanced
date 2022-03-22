package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final Map<String, Function<Integer, Integer>> operations =
                Map.of("add", x -> x + 1,
                        "multiply", x -> x * 2,
                        "subtract", x -> x - 1);

        Integer[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        String command = scan.nextLine();

        while (!"end".equals(command)) {
            if ("print".equals(command)) {
                System.out.println(
                        Arrays.stream(arr)
                                .map(String::valueOf)
                                .collect(Collectors.joining(" ")));
            } else {

                arr = Arrays.stream(arr)
                        .map(operations.get(command))
                        .toArray(Integer[]::new);
            }
            command = scan.nextLine();
        }
    }
}
