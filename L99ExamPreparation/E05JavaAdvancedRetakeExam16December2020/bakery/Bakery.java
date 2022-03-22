package L99ExamPreparation.E05JavaAdvancedRetakeExam16December2020.bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee employee = this.getEmployee(name);
        return this.employees.remove(employee);
    }

    public Employee getOldestEmployee() {
        return this.employees
                .stream()
                .sorted((e1, e2) -> e2.getAge() - e1.getAge())
                .findFirst()
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return String.format("Employees working at Bakery %s:%n%s", this.name,
                this.employees
                        .stream()
                        .map(Employee::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }
}
