package P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Person> persons = new HashMap<>();

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            persons.putIfAbsent(name, new Person(name));
            Person person = persons.get(name);

            switch (tokens[1]) {
                case "company":
                    person.setCompany(new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    break;
                case "pokemon":
                    person.addPokemon(new Pokemon(tokens[2], tokens[3]));
                    break;
                case "parents":
                    person.addParent(new Relative(tokens[2], tokens[3]));
                    break;
                case "children":
                    person.addChild(new Relative(tokens[2], tokens[3]));
                    break;
                case "car":
                    person.setCar(new Car(tokens[2], Integer.parseInt(tokens[3])));
                    break;
            }


            command = scan.nextLine();
        }

        String personName = scan.nextLine();
        System.out.println(persons.get(personName));
    }
}
