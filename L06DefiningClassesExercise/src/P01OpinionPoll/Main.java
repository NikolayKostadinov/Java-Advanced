package P01OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();
        while (count-- > 0){
            persons.add(new Person(scan.nextLine()));
        }

        System.out.println(persons.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .map(Objects::toString)
                .collect(Collectors.joining("\n")));
    }
}
