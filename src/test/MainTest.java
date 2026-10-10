package test;

import model.*;
import java.time.LocalDate;

// Demo class: creates objects with sample data and tests the methods
public class MainTest {
    public static void main(String[] args) {
        // Create employees
        MonthlyEmployee manager = new MonthlyEmployee(1, "Sara Ahmed", Gender.FEMALE,
                LocalDate.of(2018, 3, 15), 15000, 21, 10, true);
        HourlyEmployee hourly = new HourlyEmployee(2, "Omar Hassan", Gender.MALE,
                LocalDate.of(2022, 6, 1), 100, 50, 1.5);
        CommissionEmployee commission = new CommissionEmployee(3, "Mona Ali", Gender.FEMALE,
                LocalDate.of(2020, 9, 10), 5000, 5, 80000);

        // Create department and add employees
        Department dept = new Department(10, "Sales", manager, null);
        dept.addEmployee(manager);
        dept.addEmployee(hourly);
        dept.addEmployee(commission);

        System.out.println("===== Department =====");
        System.out.println(dept);

        System.out.println("\n===== All Employees =====");
        dept.printAllEmployees();

        System.out.println("\n===== Extra Details =====");
        System.out.println("Commission of Mona: " + commission.calculateCommission());
        System.out.println("Additional vacation for Sara: " + manager.calculateAdditionalVacation() + " day(s)");

        System.out.println("\n===== Total Payroll =====");
        System.out.println(dept.calculateTotalPayroll());

        System.out.println("\n===== Find Employee (id = 2) =====");
        System.out.println(dept.findEmployee(2));

        System.out.println("\n===== Remove Employee (id = 2) =====");
        dept.removeEmployee(2);
        dept.printAllEmployees();
        System.out.println("Payroll after removal: " + dept.calculateTotalPayroll());
    }
}
