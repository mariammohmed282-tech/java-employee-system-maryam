# Employee Management System

**Full Name:** Maryam Mohammed Ali
**Student ID:** 2300342

## Description
A Java project that implements a UML class diagram for an Employee Management System.
It contains an abstract `Employee` class and three employee types
(`MonthlyEmployee`, `HourlyEmployee`, `CommissionEmployee`), a `Department` class
that manages employees, and a `Gender` enum.

## Project Structure
```
EmployeeManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/ (Employee, CommissionEmployee, MonthlyEmployee, HourlyEmployee, Department, Gender)
│   └── test/MainTest.java
└── README.md
```

## How to Run
**From terminal** (inside the project folder):
```
cd src
javac model/*.java test/*.java Main.java
java Main
```
**From an IDE:** open the project, then run `Main.java` (or `test/MainTest.java`).
