package L99ExamPreparation.E10JavaAdvancedExam26Oct2019;

import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P01DatingApp {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> maleStack = readStack("\\s+");
        ArrayDeque<Integer> femaleQueue = readQueue("\\s+");

        int matchesCount = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {

            if (!gotValue(maleStack, ArrayDeque::pop)
                    || !gotValue(femaleQueue, ArrayDeque::poll)) break;

            if (maleStack.peek() == femaleQueue.peek()) {
                matchesCount++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);

        printDeque(maleStack, "Males left: none", "Males left: %s%n", ", ");
        printDeque(femaleQueue, "Females left: none", "Females left: %s%n", ", ");
    }

    private static boolean gotValue(ArrayDeque<Integer> deque, Consumer<ArrayDeque<Integer>> removeElement) {
        while (!deque.isEmpty()) {
            if (deque.peek() <= 0) {
                removeElement.accept(deque);
                continue;
            }

            if (deque.peek() % 25 == 0) {
                removeElement.accept(deque);
                removeElement.accept(deque);
                continue;
            }

            return true;
        }

        return false;
    }

    private static void printDeque(ArrayDeque<Integer> deque, String emptyMessage,
                                   String nonEmptyPattern, String delimiter) {
        if (deque.isEmpty()) {
            System.out.println(emptyMessage);
        } else {
            System.out.printf(nonEmptyPattern,
                    deque
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(delimiter)));
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
