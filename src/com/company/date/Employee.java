package com.company.date;

import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;

    private Date employmentDate;
    private Double baseSalary;
    private Position position;

    public Employee(String firstName, String lastName, Date employmentDate, Double baseSalary, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", baseSalary=" + baseSalary +
                ", position=" + position +
                '}';
    }
}
