package L99ExamPreparation.E07JavaAdvancedExam28June2020;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01Bombs {
    private static Scanner scan = new Scanner(System.in);
    private static Map<Integer, String> bombTypes =
            Map.of(40, "Datura Bombs",
                    60, "Cherry Bombs",
                    120, "Smoke Decoy Bombs");

    public static void main(String[] args) {
        ArrayDeque<Integer> bombEffectsQueue = readQueue(",\\s+");
        ArrayDeque<Integer> bombCasingStack = readStack(",\\s+");

        Map<String, Integer> producedBombs = new TreeMap<>();
        for (String bombType : bombTypes.values()) {
            producedBombs.putIfAbsent(bombType,0);
        }

        boolean allBombTypesProduced = false;
        while (!(bombEffectsQueue.isEmpty() || bombCasingStack.isEmpty())) {
            int bombEffect = bombEffectsQueue.peek();
            int bombCasing = bombCasingStack.pop();
            int bombResult = bombEffect + bombCasing;
            if (bombTypes.containsKey(bombResult)) {
                String bombType = bombTypes.get(bombResult);
                bombEffectsQueue.poll();
                producedBombs.put(bombType, producedBombs.get(bombType) + 1);
            } else {
                while(bombCasing - 5 >= 0){
                    bombCasing -= 5;
                    bombResult = bombEffect + bombCasing;
                    if (bombTypes.containsKey(bombResult)) {
                        String bombType = bombTypes.get(bombResult);
                        bombEffectsQueue.poll();
                        producedBombs.put(bombType, producedBombs.get(bombType) + 1);
                        break;
                    }
                }
            }

            allBombTypesProduced = producedBombs.entrySet().stream().allMatch(e->e.getValue()>=3);
            if (allBombTypesProduced) break;
        }

        if (allBombTypesProduced){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        printDeque(bombEffectsQueue, "Bomb Effects: empty","Bomb Effects: %s%n", ", ");
        printDeque(bombCasingStack, "Bomb Casings: empty","Bomb Casings: %s%n", ", ");

        System.out.println(producedBombs.entrySet().stream()
                .map(e -> String.format("%s: %d", e.getKey(), e.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static void printDeque(ArrayDeque<Integer> liquidsQueue, String emptyMessage,
                                   String nonEmptyPattern, String delimiter) {
        if (liquidsQueue.isEmpty()) {
            System.out.println(emptyMessage);
        } else {
            System.out.printf(nonEmptyPattern,
                    liquidsQueue
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
