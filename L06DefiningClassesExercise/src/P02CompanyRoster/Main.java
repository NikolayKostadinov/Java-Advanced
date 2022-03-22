package P02CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, List<Employee>> employees = new HashMap<>();
        while (count-- > 0) {
            Employee employee = new Employee(scan.nextLine());
            employees.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employees.get(employee.getDepartment()).add(employee);
        }

        Map.Entry<String, List<Employee>> maxDepartment =
                employees
                        .entrySet()
                        .stream()
                        .max((dep1, dep2) -> {
                            Double avgSalary1 = calculateAverageSalary(dep1);
                            Double avgSalary2 = calculateAverageSalary(dep2);
                            return avgSalary1.compareTo(avgSalary2);
                        }).orElse(null);


            System.out.println("Highest Average Salary: " + maxDepartment.getKey());
            System.out.println(maxDepartment.getValue()
                    .stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .map(Object::toString)
                    .collect(Collectors.joining("\n")));
    }

    private static double calculateAverageSalary(Map.Entry<String, List<Employee>> dep1) {
        return dep1.getValue()
                .stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0);
    }
}
