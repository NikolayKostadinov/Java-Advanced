package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Consumer<? super String> printMember = x-> System.out.printf("Sir %s%n",x);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(printMember);
    }
}
