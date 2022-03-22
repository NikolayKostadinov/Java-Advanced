package L05FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lower = scan.nextInt();
        int upper = scan.nextInt();
        scan.nextLine();
        String evenOrOdd = scan.nextLine();
        printNumbersBetween(lower, upper, getFilterBy(evenOrOdd));

    }

    private static void printNumbersBetween(int lower, int upper, Predicate<Integer> filterBy) {
        System.out.println(IntStream.range(lower, upper + 1)
                .boxed()
                .filter(filterBy)
                .map(e -> e.toString())
                .collect(Collectors.joining(" ")));
    }

    private static Predicate<Integer> getFilterBy(String evenOrOdd) {
        if ("even".equals(evenOrOdd)){
            return number -> number % 2 == 0;
        }

        return number -> number % 2 != 0;
    }

}
