package P03StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomStack<Integer> stack = new CustomStack<>();

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split("(\\s+|,\\s+)");
            switch (tokens[0]) {
                case "Push":
                    if (tokens.length > 1) {
                        push(stack, Arrays.copyOfRange(tokens, 1, tokens.length));
                    }
                    break;
                case "Pop":
                    if (stack.isEmpty()) {
                        System.out.println("No elements");
                    } else {
                       stack.pop();
                    }
                    break;
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer number : stack) {
                System.out.println(number);
            }
        }
    }

    private static void push(CustomStack<Integer> stack, String[] numbers) {
        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
    }
}
