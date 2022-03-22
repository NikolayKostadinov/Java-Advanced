package L99ExamPreparation.E05JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01Cooking {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, String> foods = Map.of(
                25, "Bread",
                50, "Cake",
                75, "Pastry",
                100, "Fruit Pie");
        Map<String, Integer> cookedFoods = new TreeMap<>(){{
           put("Bread", 0);
           put("Cake", 0);
           put("Pastry", 0);
           put("Fruit Pie", 0);
        }};

        ArrayDeque<Integer> liquidsQueue = readQueue("\\s+");
        ArrayDeque<Integer> ingredientsStack = readStack("\\s+");

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int volume = liquid + ingredient;
            if (foods.containsKey(volume)) {
                String foodName = foods.get(volume);
                cookedFoods.put(foodName, cookedFoods.get(foodName) + 1);
            } else {
                ingredientsStack.push(ingredient + 3);
            }
        }

        printResult(cookedFoods);

        printDeque(liquidsQueue, "Liquids left: none", "Liquids left: %s%n");
        printDeque(ingredientsStack, "Ingredients left: none","Ingredients left: %s%n");

        System.out.println(cookedFoods
                .entrySet()
                .stream()
                .map(x -> String.format("%s: %d", x.getKey(), x.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));


    }

    private static void printResult(Map<String, Integer> cookedFoods) {
        if (cookedFoods.entrySet().stream().allMatch(x -> x.getValue() > 0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
    }

    private static void printDeque(ArrayDeque<Integer> liquidsQueue, String emptyMessage, String nonEmptyPattern) {
        if (liquidsQueue.isEmpty()) {
            System.out.println(emptyMessage);
        } else {
            System.out.printf(nonEmptyPattern,
                    liquidsQueue
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", ")));
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
