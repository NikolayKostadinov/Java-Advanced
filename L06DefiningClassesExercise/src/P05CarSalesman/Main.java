package P05CarSalesman;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, Engine> engines = getEngines(scan);
        printCars(engines, scan);
    }

    private static void printCars(Map<String, Engine> engines, Scanner scan) {
        int count = Integer.parseInt(scan.nextLine());
        while (count-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            Engine engine = engines.get(tokens[1]);
            Car car;
            if (tokens.length == 3) {
                try {
                    Integer weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException ex) {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            } else if (tokens.length == 4) {
                Integer weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else {
                car = new Car(model, engine);
            }
            System.out.println(car);
        }
    }

    private static Map<String, Engine> getEngines(Scanner scan) {
        int count = Integer.parseInt(scan.nextLine());

        Map<String, Engine> engines = new HashMap<>();
        while (count-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine;
            if (tokens.length == 3) {
                try {
                    Integer displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException ex) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (tokens.length == 4) {
                Integer displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else {
                engine = new Engine(model, power);
            }

            engines.put(model, engine);
        }

        return engines;
    }
}
