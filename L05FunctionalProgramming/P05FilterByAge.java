package L05FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] tokens = scan.nextLine().split(", ");
            people.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        String ageCondition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String outputFormat = scan.nextLine();

        people.entrySet()
                .stream()
                .filter(getAgeFilter(ageCondition, age))
                .forEach(getPrintEntryConsumer(outputFormat));

    }

    private static Consumer<Map.Entry<String, Integer>> getPrintEntryConsumer(String outputFormat) {
        switch (outputFormat) {
            case "name":
                return entry -> System.out.println(entry.getKey());
            case "age":
                return entry -> System.out.println(entry.getValue());
            default:
                return entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(String ageCondition, int age) {
        if ("older".equals(ageCondition)) {
            return entry -> entry.getValue() >= age;
        }
        return entry -> entry.getValue() <= age;
    }
}
