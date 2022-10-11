package JavaAdvancedRetakeExam18August2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }
    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public int getCount() {
        return employees.size();
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Employees working at Cafe %s:",name)).append(System.lineSeparator());

        for (Employee employee : employees) {
            stringBuilder.append(employee).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
