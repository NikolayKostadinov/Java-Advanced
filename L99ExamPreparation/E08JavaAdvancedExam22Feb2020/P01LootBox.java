package L99ExamPreparation.E08JavaAdvancedExam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01LootBox {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> firstBoxQueue = readQueue("\\s+");
        ArrayDeque<Integer> secondBoxStack = readStack("\\s+");

        int claimedItemsCount = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.pop();
            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                claimedItemsCount += sum;
            } else {
                firstBoxQueue.offer(secondItem);
            }
        }

        printEmptyMessage(firstBoxQueue, "First lootbox is empty");
        printEmptyMessage(secondBoxStack, "Second lootbox is empty");

        if (claimedItemsCount >= 100){
            System.out.printf("Your loot was epic! Value: %d", claimedItemsCount);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItemsCount);
        }
    }

    private static void printEmptyMessage(ArrayDeque<Integer> firstBoxQueue, String message) {
        if (firstBoxQueue.isEmpty()) System.out.println(message);
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
