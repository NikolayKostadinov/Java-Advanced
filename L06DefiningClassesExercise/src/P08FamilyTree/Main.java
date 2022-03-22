package P08FamilyTree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final String DATE_PATTERN = "^\\d+\\/\\d+\\/\\d+$";

    private static Map<String, Person> relativesByDate = new LinkedHashMap<>();
    private static Map<String, Person> relativesByName = new LinkedHashMap<>();
    private static Map<String, List<String>> relation = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String targetPerson = scan.nextLine();

        readInput(scan);
        applyRelations();

        Person person = findPerson(targetPerson);

        System.out.println(getFamilyTreeFor(person));
    }

    private static void applyRelations() {
        relation
                .entrySet()
                .stream()
                .forEach(entry -> {
                    String parentId = entry.getKey();
                    List<String> children = entry.getValue();
                    Person parent;
                    parent = findPerson(parentId);
                    children
                            .stream()
                            .map(Main::findPerson)
                            .forEach(child -> {
                                parent.addChild(child);
                                child.addParent(parent);
                            });
                });
    }

    private static Person findPerson(String parentId) {
        Person parent;
        if (parentId.matches(DATE_PATTERN)) {
            parent = relativesByDate.get(parentId);
        } else {
            parent = relativesByName.get(parentId);
        }
        return parent;
    }

    private static void readInput(Scanner scan) {
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            if (input.contains(" - ")) {
                String tokens[] = input.split(" - ");
                relation.putIfAbsent(tokens[0], new ArrayList<>());
                relation.get(tokens[0]).add(tokens[1]);
            } else {

                String[] tokens = input.split("\\s+");

                String name = tokens[0] + " " + tokens[1];
                String date = tokens[2];

                Person person = new Person(name, date);
                relativesByDate.putIfAbsent(date, person);
                relativesByName.putIfAbsent(name, person);
            }

            input = scan.nextLine();
        }
    }

    public static String getFamilyTreeFor(Person person) {
        return new StringBuilder()
                .append(person.toString()).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .append(person.getParents().isEmpty() ? "" : System.lineSeparator())
                .append("Children:").append(System.lineSeparator())
                .append(person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
