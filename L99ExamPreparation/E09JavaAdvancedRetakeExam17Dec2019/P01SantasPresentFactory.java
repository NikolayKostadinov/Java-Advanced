package L99ExamPreparation.E09JavaAdvancedRetakeExam17Dec2019;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    private static Scanner scan = new Scanner(System.in);
    private static final Map<Integer, String> presentMagic = Map.of(
            150, "Doll",
            250, "Wooden train",
            300, "Teddy bear",
            400, "Bicycle");

    private static Map<String, Integer> toys = new TreeMap<>() {{
        put("Doll", 0);
        put("Wooden train", 0);
        put("Teddy bear", 0);
        put("Bicycle", 0);
    }};

    public static void main(String[] args) {
        ArrayDeque<Integer> materialsStack = readStack("\\s+");
        ArrayDeque<Integer> magicQueue = readQueue("\\s+");
        boolean isPresentCrafted = craftPresents(materialsStack, magicQueue);

        if (isPresentCrafted) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        printDeque(materialsStack, "Materials left: %s%n", ", ");
        printDeque(magicQueue, "Magic left: %s%n", ", ");

        System.out.println(toys.entrySet()
                .stream()
                .filter(x -> x.getValue() > 0)
                .map(t -> String.format("%s: %s", t.getKey(), t.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static boolean craftPresents(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicQueue) {
        while (!magicQueue.isEmpty() && !materialsStack.isEmpty()) {
            int totalMagic = materialsStack.peek() * magicQueue.peek();
            if (totalMagic == 0) {
                if (magicQueue.peek() == 0) magicQueue.poll();
                if (materialsStack.peek() == 0) materialsStack.pop();
            } else {
                int material = materialsStack.pop();
                int magic = magicQueue.poll();
                if (presentMagic.containsKey(totalMagic)) {
                    String toyName = presentMagic.get(totalMagic);
                    toys.put(toyName, toys.get(toyName) + 1);
                } else if (totalMagic < 0) {
                    materialsStack.push(magic + material);
                } else if (totalMagic > 0) {
                    materialsStack.push(material + 15);
                }
            }
        }

        return (toys.get("Doll") >= 1 && toys.get("Wooden train") >= 1)
                || (toys.get("Teddy bear") >= 1 && toys.get("Bicycle") >= 1);
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

    private static void printDeque(ArrayDeque<Integer> liquidsQueue, String nonEmptyPattern, String delimiter) {
        if (!liquidsQueue.isEmpty()) {
            System.out.printf(nonEmptyPattern,
                    liquidsQueue
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(delimiter)));
        }
    }
}
