package P05CarSalesman;

public class Car {
    String model;
    Engine engine;
    Integer weight;
    String color;

    public Car(String model, Engine engine) {
        this(model, engine, null, "n/a");
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, null, color);
    }

    public Car(String model, Engine engine, Integer weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return model + ":\n" +
                engine.model + ":\n" +
                "Power: " + engine.power + "\n" +
                "Displacement: " + ((engine.displacement == null) ? "n/a" : engine.displacement.toString()) + "\n" +
                "Efficiency: " + engine.efficiency + "\n" +
                "Weight: " + ((this.weight == null) ? "n/a" : this.weight.toString()) + "\n" +
                "Color: " + this.color;

    }
}
