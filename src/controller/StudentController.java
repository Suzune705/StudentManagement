package src.controller;

import src.services.StudentServices;
import src.model.Students;

import java.io.File;

import java.util.*;

public class StudentController {
    public static Scanner sc = new Scanner(System.in);
    Students s;

    public static void controller() {
        File file = new File("src/data/StudentInformation.txt");
        StudentServices studentServices = new StudentServices();

        int choice;
        do {
            System.out.println("-------------------Menu------------------");
            System.out.println("1. 📊 Check loaded students");
            System.out.println("2. Display Student Information From File");
            System.out.println("3. Add a student ");
            System.out.println("4. Display Student Information From Main list");
            System.out.println("5. Remove student by id");

            System.out.println("11. Exit ");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1. 📊 Check loaded students");
                    studentServices.checkLoadStudentInformation();
                    break;
                case 2:
                    System.out.println("2. Display Student Information From FILE");
                    studentServices.displayStudentInformationFromFile();
                    break;
                case 3:
                    System.out.println("3. Add a student To File ");
                    studentServices.addNewStudents();
                    break;
                case 4:
                    System.out.println("Display Student From Main List");
                    studentServices.displayStudentInformationFromMainList();
                    break;
                case 5:
                    System.out.println("5. Remove student by ID");
                    System.out.print("Enter id of student to remove : ");
                    String id = sc.nextLine();
                    studentServices.RemoveStudentID(id );
                    break;
                case 6 :
                    System.out.println("6. Update specific student");

                    break;
            }
        } while (choice != 8);
    }

}
