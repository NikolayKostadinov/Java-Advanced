package P11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(" ");
        Threeuple<Person, String, String> threeuple1 = new Threeuple<>(new Person(tokens[0], tokens[1]), tokens[2], tokens[3]);
        tokens = scan.nextLine().split(" ");
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(tokens[0], Integer.parseInt(tokens[1]), (tokens[2].equals("drunk")));
        tokens = scan.nextLine().split(" ");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);

        System.out.printf("%s -> %s -> %s%n", threeuple1.getItem1(), threeuple1.getItem2(), threeuple1.getItem3());
        System.out.printf("%s -> %d -> %s%n", threeuple2.getItem1(), threeuple2.getItem2(), threeuple2.getItem3());
        System.out.printf("%s -> %s -> %s%n", threeuple3.getItem1(), threeuple3.getItem2(), threeuple3.getItem3());
    }
}
