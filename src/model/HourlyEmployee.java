package model;

import java.time.LocalDate;

// Employee who is paid per hour, with extra pay for overtime
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate; // multiplier, e.g. 1.5 means 1.5x the hourly rate

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public double getOvertimeRate() { return overtimeRate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public void setOvertimeRate(double overtimeRate) { this.overtimeRate = overtimeRate; }

    // First 40 hours are normal pay, anything above is overtime
    @Override
    public double calculateSalary() {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyRate;
        }
        double overtimeHours = hoursWorked - 40;
        return (40 * hourlyRate) + (overtimeHours * hourlyRate * overtimeRate);
    }

    @Override
    public String toString() {
        return "HourlyEmployee [" + super.toString() + ", Hourly Rate: " + hourlyRate
                + ", Hours Worked: " + hoursWorked + ", Overtime Rate: " + overtimeRate
                + ", Total Salary: " + calculateSalary() + "]";
    }
}
