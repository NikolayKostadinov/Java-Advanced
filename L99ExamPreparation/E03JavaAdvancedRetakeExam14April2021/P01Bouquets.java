package L99ExamPreparation.E03JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01Bouquets {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> tulipsStack = readStack(",\\s+");
        ArrayDeque<Integer> daffodilsQueue = readQueue(",\\s+");

        int bouquetsCount = 0;
        int storedFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int flowers = tulipsStack.peek() + daffodilsQueue.peek();
            if (flowers == 15) {
                tulipsStack.pop();
                daffodilsQueue.poll();
                bouquetsCount++;
            } else if (flowers > 15) {
                tulipsStack.push(tulipsStack.pop()-2); ;
            } else {
                storedFlowers += flowers;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }

        if (storedFlowers > 15) {
            bouquetsCount += storedFlowers / 15;
        }

        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCount);
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
