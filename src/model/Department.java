package model;

import java.util.ArrayList;
import java.util.List;

// A department has a manager and a list of employees
public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee e : employees) {
                addEmployee(e);
            }
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Employee getManager() { return manager; }
    public List<Employee> getEmployees() { return employees; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setManager(Employee manager) { this.manager = manager; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    // Add an employee and link him/her to this department
    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }

    // Remove an employee by id
    public void removeEmployee(int employeeId) {
        Employee e = findEmployee(employeeId);
        if (e != null) {
            employees.remove(e);
            e.setDepartment(null);
        } else {
            System.out.println("Employee with id " + employeeId + " not found.");
        }
    }

    // Find an employee by id (returns null if not found)
    public Employee findEmployee(int employeeId) {
        for (Employee e : employees) {
            if (e.getId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    // Sum of all employees' salaries
    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public void printAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        String managerName = (manager == null) ? "None" : manager.getName();
        return "Department [ID: " + id + ", Name: " + name + ", Manager: " + managerName
                + ", Number of Employees: " + employees.size() + "]";
    }
}
