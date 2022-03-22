package P06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Person> firstSet = new TreeSet<>(new PersonComparatorByName());
        Set<Person> secondSet = new TreeSet<>(new PersonComparatorByAge());

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            firstSet.add(person);
            secondSet.add(person);
        }

        printSet(firstSet);
        printSet(secondSet);
    }

    private static void printSet(Set<Person> firstSet) {
        System.out.println(firstSet
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
