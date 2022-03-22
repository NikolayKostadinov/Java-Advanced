package P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map<String, Car> cars = getCars(scan, count);
        driveTheRace(scan, cars);
        printResult(cars);

    }

    private static void printResult(Map<String, Car> cars) {
        System.out.println(cars.values()
                .stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n")));
    }

    private static void driveTheRace(Scanner scan, Map<String, Car> cars) {
        String command = scan.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);
            if (cars.get(model).canMoveDistance(distance)) {
                cars.get(model).move(distance);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scan.nextLine();
        }
    }

    private static Map<String, Car> getCars(Scanner scan, int count) {
        Map<String, Car> cars = new LinkedHashMap<>();
        while (count-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            cars.put(model, new Car(model, fuelAmount, fuelCostPerKm));
        }

        return cars;
    }
}
