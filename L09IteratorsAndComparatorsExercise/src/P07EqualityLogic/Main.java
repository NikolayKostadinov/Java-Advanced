package P07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Person> firstSet = new TreeSet<>();
        Set<Person> secondSet = new HashSet<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            firstSet.add(person);
            secondSet.add(person);
        }

        System.out.println(firstSet.size());
        System.out.println(secondSet.size());
    }
}
