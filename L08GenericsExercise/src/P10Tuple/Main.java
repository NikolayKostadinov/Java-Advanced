package P10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(" ");
        Tuple<Person, String> tuple1 = new Tuple<>(new Person(tokens[0], tokens[1]), tokens[2]);
        tokens = scan.nextLine().split(" ");
        Tuple<String, Integer> tuple2 = new Tuple<>(tokens[0], Integer.parseInt(tokens[1]));
        tokens = scan.nextLine().split(" ");
        Tuple<Integer, Double> tuple3 = new Tuple<>(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]));

        System.out.printf("%s -> %s%n", tuple1.getItem1(), tuple1.getItem2());
        System.out.printf("%s -> %d%n", tuple2.getItem1(), tuple2.getItem2());
        System.out.printf("%d -> %s%n", tuple3.getItem1(), tuple3.getItem2());
    }
}
