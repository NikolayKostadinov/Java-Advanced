package L05FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {

    private static final Map<String, Function<String, Predicate<String>>> filters = getFilters();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        Map<String, Predicate<String>> predicates = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!"Print".equals(line)) {
            processFilter(predicates, line);
            line = scanner.nextLine();
        }

        Predicate<String> combinedPredicate = x -> true;

        for (Predicate<String> pr : predicates.values()) {
            combinedPredicate = combinedPredicate.and(pr);
        }

        System.out.println(
                guests
                .stream()
                .filter(combinedPredicate)
                .collect(Collectors.joining(" ")));
    }

    private static void processFilter(Map<String, Predicate<String>> predicates, String input) {
        String[] tokens = input.split(";");
        String command = tokens[0];
        String filter = tokens[1];
        String parameter = tokens[2];
        String filterName = tokens[1] + tokens[2];

        Predicate<String> filterPredicate = filters.get(filter).apply(parameter);

        if ("Add filter".equals(command)) {
            predicates.putIfAbsent(filterName, filterPredicate);

        } else {
            predicates.remove(filterName);
        }
    }


    private static Map<String, Function<String, Predicate<String>>> getFilters() {
        return Map.of(
                "Starts with", (parameter) -> s -> !s.startsWith(parameter),
                "Ends with", (parameter) -> s -> !s.endsWith(parameter),
                "Length", (parameter) -> s -> s.length() != Integer.parseInt(parameter),
                "Contains", (parameter) -> s -> !s.contains(parameter));
    }
}
