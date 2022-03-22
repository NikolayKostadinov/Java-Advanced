package P07Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.name + " " + this.department + " " + String.format("%.2f", this.salary);
    }
}
