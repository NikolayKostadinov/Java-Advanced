package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private final List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        Car car = this.getCar(manufacturer, model);
        if (car == null) return false;
        return this.data.remove(car);
    }

    public Car getLatestCar() {
        return this.data
                .stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(c ->
                c.getManufacturer().equals(manufacturer)
                        && c.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The cars are parked in %s:", this.type) +
                ((this.data.isEmpty()) ? ""
                        : System.lineSeparator() + this.data.stream()
                        .map(Car::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                );
    }
}
