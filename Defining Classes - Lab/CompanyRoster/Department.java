package Practice.CompanyRoster;

import Practice.CompanyRoster.Employee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAvgSalary() {
        return this.employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}
