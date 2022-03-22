package L99ExamPreparation.E04JavaAdvancedExam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01MagicBox {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> firstQueue = readQueue("\\s+");
        ArrayDeque<Integer> secondStack = readStack("\\s+");

        int claimedItems = 0;
        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {
            int secondItem = secondStack.pop();
            int sum = firstQueue.peek() + secondItem;
            if (sum % 2 == 0) {
                claimedItems += sum;
                firstQueue.pop();
            } else {
                firstQueue.offer(secondItem);
            }
        }

        if (firstQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }


    private static ArrayDeque<Integer> readStack(String delimiter) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        getMembers(stack, stack::push, delimiter);
        return stack;
    }

    private static ArrayDeque<Integer> readQueue(String delimiter) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        getMembers(queue, queue::offer, delimiter);
        return queue;
    }

    private static void getMembers(ArrayDeque<Integer> deque, Consumer<Integer> operation, String separator) {
        Arrays.stream(scan.nextLine().split(separator))
                .map(Integer::parseInt)
                .forEach(operation);
    }
}
