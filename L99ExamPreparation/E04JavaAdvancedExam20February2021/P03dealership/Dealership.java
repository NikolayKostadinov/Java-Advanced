package L99ExamPreparation.E04JavaAdvancedExam20February2021.P03dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        int indexOfCar = this.data.indexOf(new Car(manufacturer, model));
        if (indexOfCar > -1) {
            this.data.remove(indexOfCar);
            return true;
        }
        return false;
    }

    public Car getLatestCar() {
        return this.data.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .findFirst().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        Car otherCar = new Car(manufacturer, model);
        return this.data.stream()
                .filter(car -> car.equals(otherCar))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The cars are in a car dealership %s:%n", this.name) +
                (this.data.isEmpty() ? "" :
                        this.data.stream()
                                .map(Car::toString)
                                .collect(Collectors.joining(System.lineSeparator())));
    }
}
