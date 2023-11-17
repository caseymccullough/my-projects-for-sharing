package org.example;

public class Student extends Person {

    private int[] grades;

    public Student(String firstName, String lastName, int[] grades) {
        super(firstName, lastName);
        this.grades = grades;
    }


    public int[] getGrades() {
        return grades;
    }

    public double getAverage(){
        int sum = 0;
        for (int grade: grades) {
            sum += grade;
        }
        return (double)sum / grades.length;
    }

    @Override
    public String toString () {
        String s = super.toString();
        s += "\nAverage: " + getAverage();
        s += "\nGrades: ";
        for (int grade: grades) {
            s += "\t" + grade;
        }

        return s;
    }
}
