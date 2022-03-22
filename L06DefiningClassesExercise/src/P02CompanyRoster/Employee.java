package P02CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Employee(String input) {
        //Peter 120.00 Dev Development peter@abv.bg 28
        String[] tokens = input.split("\\s+");
        this.name = tokens[0];
        this.salary = Double.parseDouble(tokens[1]);
        this.position = tokens[2];
        this.department = tokens[3];
        if (tokens.length == 5) {
            try {
                this.age = Integer.parseInt(tokens[4]);
            } catch (Exception ex) {
                this.email = tokens[4];
            }
        }
        if (tokens.length == 6) {
            this.email = tokens[4];
            this.age = Integer.parseInt(tokens[5]);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
