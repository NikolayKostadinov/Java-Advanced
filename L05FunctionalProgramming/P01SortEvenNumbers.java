package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .toArray();
        String delimiter = ", ";

        Function<IntStream, String> joinNumbers = (stream) -> stream
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(delimiter));

        System.out.println(joinNumbers.apply(Arrays.stream(numbers)));
        System.out.println(joinNumbers.apply(Arrays.stream(numbers).sorted()));
    }
}
