package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split(", ");

        Function<String[], IntStream> parse = (input) -> Arrays.stream(input).mapToInt(Integer::parseInt);

        System.out.printf("Count = %s%n", numbers.length);
        System.out.printf("Sum = %s%n",parse.apply(numbers).sum());
    }
}
