package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Comparator<Integer> comparator = (n1, n2) ->
                (isEven(n1) && !isEven(n2)) ? -1 :
                        (isEven(n2) && !isEven(n1)) ? 1 :
                                n1.compareTo(n2);

        System.out.println(Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(comparator)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}
