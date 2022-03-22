package L99ExamPreparation.E02JavaAdvancedExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01OSPlaning {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> tasks = readStack(",\\s+");
        ArrayDeque<Integer> threads = readQueue("\\s+");

        int terminalTask = Integer.parseInt(scan.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int thread = threads.peek();
            int task = tasks.peek();

            if (task == terminalTask) {
                System.out.printf("Thread with value %d killed task %d%n", thread, terminalTask);
                break;
            }

            threads.pop();
            if (thread >= task) {
                tasks.pop();
            }
        }

        if (!threads.isEmpty()) {
            System.out.println(threads.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
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
