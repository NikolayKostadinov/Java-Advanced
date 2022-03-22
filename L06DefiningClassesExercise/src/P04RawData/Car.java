package P04RawData;

import java.util.Arrays;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public boolean hasPowerfullEngine() {
        return this.engine.getPower() > 250;
    }

    public boolean hasFlatTire(){
        return Arrays.stream(this.tires).anyMatch(t->t.getPressure() < 1);
    }
}
