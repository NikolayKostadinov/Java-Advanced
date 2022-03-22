package P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scan.nextLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            input = scan.nextLine();
        }

        int personIndex = Integer.parseInt(scan.nextLine());
        if (people.size() > personIndex) {
            Person person = people.get(personIndex);

            int equal = 0;

            for (int i = 0; i < people.size(); i++) {
                if (people.get(i).compareTo(person) == 0) {
                    equal++;
                }
            }

            System.out.printf("%d %d %d", equal, people.size() - equal, people.size());

        } else {
            System.out.println("No matches");
        }
    }
}
