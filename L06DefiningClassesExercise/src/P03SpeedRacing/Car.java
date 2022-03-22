package P03SpeedRacing;

public class Car {
    private final String model;
    private Double fuelAmount;
    private final Double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, Double fuelAmount, Double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public String getModel() {
        return this.model;
    }

    public boolean canMoveDistance(int distance){
        return fuelCostPerKm * distance <= fuelAmount;
    }

    public void move(int distance) {
        this.distanceTraveled += distance;
        this.fuelAmount -= this.fuelCostPerKm * distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
