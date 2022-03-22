package P04RawData;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, Predicate<Car>> filters =
                Map.of("fragile", Car::hasFlatTire,
                        "flamable", Car::hasPowerfullEngine);

        Map<String, List<Car>> dataTable = readCars(count, scan);

        String command = scan.nextLine();
        System.out.println(dataTable.get(command)
                .stream()
                .filter(filters.get(command))
                .map(x -> x.getModel())
                .collect(Collectors.joining("\n")));
    }

    private static Map<String, List<Car>> readCars(int count, Scanner scan) {
        Map<String, List<Car>> data = new HashMap<>();

        while (count-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = new Tire[4];
            for (int i = 0; i < 4; i++) {
                double pressure = Double.parseDouble(tokens[5 + (i * 2)]);
                int age = Integer.parseInt(tokens[5 + (i * 2) + 1]);
                tires[i] = new Tire(pressure, age);
            }

            data.putIfAbsent(cargoType, new ArrayList<>());
            data.get(cargoType).add(new Car(model, engine, cargo, tires));
        }

        return data;
    }
}
