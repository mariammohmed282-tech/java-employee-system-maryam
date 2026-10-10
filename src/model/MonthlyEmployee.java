package model;

import java.time.LocalDate;
import java.time.Period;

// Employee who gets a fixed monthly salary plus a bonus
public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonousPercentage; // percentage, e.g. 10 means 10%
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays,
                           double bonousPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        this.monthlySalary = monthlySalary;
        this.vacationDays = vacationDays;
        this.bonousPercentage = bonousPercentage;
        this.hasHealthInsurance = hasHealthInsurance;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public int getVacationDays() { return vacationDays; }
    public double getBonousPercentage() { return bonousPercentage; }
    public boolean isHasHealthInsurance() { return hasHealthInsurance; }

    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }
    public void setBonousPercentage(double bonousPercentage) { this.bonousPercentage = bonousPercentage; }
    public void setHasHealthInsurance(boolean hasHealthInsurance) { this.hasHealthInsurance = hasHealthInsurance; }

    @Override
    public double calculateSalary() {
        return monthlySalary + (monthlySalary * bonousPercentage / 100);
    }

    // One extra vacation day for every 2 years of service
    public int calculateAdditionalVacation() {
        int years = Period.between(getHireDate(), LocalDate.now()).getYears();
        return years / 2;
    }

    @Override
    public String toString() {
        return "MonthlyEmployee [" + super.toString() + ", Monthly Salary: " + monthlySalary
                + ", Vacation Days: " + vacationDays + ", Bonus: " + bonousPercentage
                + "%, Health Insurance: " + hasHealthInsurance
                + ", Total Salary: " + calculateSalary() + "]";
    }
}
