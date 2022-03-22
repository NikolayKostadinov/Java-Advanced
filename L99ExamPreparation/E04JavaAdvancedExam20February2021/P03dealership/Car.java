package L99ExamPreparation.E04JavaAdvancedExam20February2021.P03dealership;

public class Car {
    public String manufacturer;
    public String model;
    public int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public Car(String manufacturer, String model) {
        this(manufacturer,model,0);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.manufacturer, this.model, this.year);
    }

    @Override
    public boolean equals(Object obj) {
        Car other = (Car) obj;
        return this.manufacturer.equals(other.manufacturer) && this.model.equals(other.model);
    }
}
