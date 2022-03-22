package L99ExamPreparation.E06JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01FlowerWreaths {
    private static Scanner scan = new Scanner(System.in);
    private static final int FLOWER_WREATHS_GOAL = 5;
    private static final int FLOWERS_IN_WREATHS = 15;

    public static void main(String[] args) {
        ArrayDeque<Integer> liliesStack = readStack(",\\s+");
        ArrayDeque<Integer> rosesQueue = readQueue(",\\s+");
        int flowerWreaths = makeWreaths(liliesStack, rosesQueue);
        printResult(flowerWreaths);
    }

    private static int makeWreaths(ArrayDeque<Integer> liliesStack, ArrayDeque<Integer> rosesQueue) {
        int flowerWreaths = 0;
        int flowersStore = 0;
        while (!(rosesQueue.isEmpty() || liliesStack.isEmpty())) {
            int lilies = liliesStack.pop();
            int roses = rosesQueue.poll();
            int flowers = roses + lilies;
            if (flowers == FLOWERS_IN_WREATHS) {
                flowerWreaths++;
            } else if (flowers > FLOWERS_IN_WREATHS) {
                while (flowers > FLOWERS_IN_WREATHS) {
                    flowers -= 2;
                    if (flowers == FLOWERS_IN_WREATHS) {
                        flowerWreaths++;
                        flowers = 0;
                    } else if (flowers<FLOWERS_IN_WREATHS){
                        flowersStore += flowers;
                    }
                }
            } else if (flowers < FLOWERS_IN_WREATHS) {
                flowersStore += flowers;
            }
        }
        flowerWreaths += flowersStore / FLOWERS_IN_WREATHS;
        return flowerWreaths;
    }

    private static void printResult(int flowerWreaths) {
        if (flowerWreaths >= FLOWER_WREATHS_GOAL) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", flowerWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", FLOWER_WREATHS_GOAL - flowerWreaths);
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
