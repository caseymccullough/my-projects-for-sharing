package org.example;

import java.text.NumberFormat;

public class Teacher extends Person {

    private final static NumberFormat FORMATTER = NumberFormat.getCurrencyInstance();

    private double salary;

    public Teacher(String firstName, String lastName, double salary) {
        super(firstName, lastName);
        this.salary = salary;
    }


    public double getSalary() {
        return salary;
    }

    public double getWeeklySalary() {
        return salary / 52;
    }

    @Override
    public String toString () {
        String s = super.toString();
        s += "\nSalary: " + FORMATTER.format(salary);
        return s;
    }
}
