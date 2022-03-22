package L05FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Consumer<? super String> printMember = x-> System.out.println(x);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(printMember);
    }
}
