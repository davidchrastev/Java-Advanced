package JavaAdvancedRetakeExam16December2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    public List<Employee> employees;
    public String name;
    public int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
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
        stringBuilder.append("Employees working at Bakery ").append(name).append(":").append(System.lineSeparator());
        for (Employee employee : employees) {
            stringBuilder.append(employee).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
