package P05CarSalesman;

public class Engine {
    String model;
    int power;
    Integer displacement ;
    String efficiency;

    public Engine(String model, int power) {
        this(model,power,null, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, null, efficiency);
    }

    public Engine(String model, int power, Integer displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, Integer displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
}
