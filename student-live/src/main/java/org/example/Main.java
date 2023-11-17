package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Student> allStudents = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        int [] student1Grades = {90, 95, 100};
        Student student1 = new Student ("Joe", "Jackson", student1Grades);
        int[] student2Grades = {78, 88, 97};
        Student student2 = new Student ("Frank", "Stallone", student2Grades);

        allStudents.add(student1);
        allStudents.add(student2);

        int menuChoice = 0;
        do {
            showMenu();
            menuChoice = sc.nextInt();
            if (menuChoice < 1 || menuChoice > 3){
                System.out.println("INVALID: Choose between 1 and 3");
            }

        }while (menuChoice < 1 || menuChoice > 3);

        if (menuChoice == 1) {
            System.out.println("ALL STUDENTS");
            showStudents(allStudents);
        } else if (menuChoice == 2) {
            System.out.print("Please enter the search term: ");
            String searchTerm = sc.nextLine();
            Student foundStudent = searchForStudent(searchTerm);
            if (foundStudent == null) {
                System.out.println("That student was not found");
            } else {
                System.out.println("That student was found: ");
                System.out.println(foundStudent);
            }
        } else {
            System.out.println("HONOR ROLL: ");
            List<Student> honorRoll = generateHonorRoll();
            showStudents(honorRoll);
        }
    }

    public static void showMenu () {
        System.out.println("OPTIONS: ");
        System.out.println("1) Show all students");
        System.out.println("2) Find student by name");
        System.out.println("3) Generate honor roll");
    }

    public static void showStudents(List<Student> students){
        for (Student student : students){
            System.out.println(student);
        }
    }

    public static Student searchForStudent(String searchTerm) {
        for (Student student : allStudents){
            String fullName = student.getFirstName() + " " + student.getLastName();
            if (fullName.contains(searchTerm)){
                return student;
            }
        }
        return null;
    }

    public static List<Student> generateHonorRoll() {
        List <Student> honorRoll = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getAverage() >= 85) {
                honorRoll.add(student);
            }
        }
        return honorRoll;
    }
}