import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01Problem1 {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

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
