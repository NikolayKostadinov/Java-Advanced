package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Function<int[], Integer> minIndex = getMinimumIndex();

        System.out.println(
                minIndex.apply(
                        Arrays.stream(scan.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray()));
    }

    private static Function<int[], Integer> getMinimumIndex() {
        return arr -> {
            int min = Integer.MAX_VALUE;
            int minIx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= min) {
                    min = arr[i];
                    minIx = i;
                }
            }
            return minIx;
        };
    }
}
