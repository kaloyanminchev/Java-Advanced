package Practice.CompanyRoster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departments = new HashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String departmentName = tokens[3];

            Employee employee = new Employee(
                    tokens[0],
                    Double.parseDouble(tokens[1]),
                    tokens[2]);

            if (tokens.length == 5) {
                if (!Character.isDigit(tokens[4].charAt(0))) {
                    employee.setEmail(tokens[4]);
                } else {
                    employee.setAge(Integer.parseInt(tokens[4]));
                }
            } else if (tokens.length == 6) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department());
            }
            departments.get(departmentName).addEmployee(employee);
        }

        departments.entrySet()
                .stream()
                .sorted((f, s) -> Double.compare(s.getValue().getAvgSalary(), f.getValue().getAvgSalary()))
                .limit(1)
                .forEach(entry -> {

                    System.out.println("Highest Average Salary: " + entry.getKey());

                    entry.getValue().getEmployees()
                            .stream()
                            .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                            .forEach(employee ->

                                    System.out.println(String.format("%s %.2f %s %d",
                                            employee.getName(),
                                            employee.getSalary(),
                                            employee.getEmail(),
                                            employee.getAge())));
                });
    }
}
