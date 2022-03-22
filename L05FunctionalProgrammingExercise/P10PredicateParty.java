package L05FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    private static final Map<String, Function<String, Predicate<String>>> filters = getFilters();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!"Party!".equals(command)) {
            String[] tokens = command.split("\\s+");
            String operation = tokens[0];
            String filter = tokens[1];
            String parameter = tokens[2];

            executeOperation(guests, operation, filter, parameter);

            command = scan.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", guests.stream()
                    .sorted()
                    .collect(Collectors.joining(", ")));
        }
    }

    private static void executeOperation(List<String> guests, String operation, String filter, String parameter) {
        Predicate<String> duplicationPredicate = filters.get(filter).apply(parameter);

        List<String> modified = guests.stream()
                .filter(duplicationPredicate)
                .collect(Collectors.toList());

        if (modified.size() > 0) {
            if (operation.equals("Double")) {
                guests.addAll(modified);
            } else {
                guests.removeAll(modified);
            }
        }
    }

    private static Map<String, Function<String, Predicate<String>>> getFilters() {
        return Map.of("StartsWith", (parameter) -> (tested) -> tested.startsWith(parameter),
                "EndsWith", (parameter) -> (tested) -> tested.endsWith(parameter),
                "Length", (parameter) -> (tested) -> tested.length() == Integer.parseInt(parameter));
    }
}
