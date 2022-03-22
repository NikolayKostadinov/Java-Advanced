import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
                Arrays.stream(scan.nextLine()
                                .split("\\s+"))
                        .forEach(x -> stack.push(Integer.parseInt(x)));

        for (Integer number : stack) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
