package src.controller;

import src.services.StudentServices;
import src.model.Students;

import java.io.File;

import java.sql.SQLOutput;
import java.util.*;

public class StudentController {

    public static Scanner sc = new Scanner(System.in);

    public static void controller() {
        StudentServices studentServices = new StudentServices();
        int choice;
        do {
            System.out.println("╔════════════════════════════ MENU ════════════════════════════╗");
            System.out.printf ("║ %-3s %-56s ║%n", "1.", "📊 Check loaded students into file");
            System.out.printf ("║ %-3s %-57s ║%n", "2.", "🗂️  Display Student Information From File");
            System.out.printf ("║ %-3s %-55s ║%n", "3.", "➕ Add a student");
            System.out.printf ("║ %-3s %-56s ║%n", "4.", "📋 Display Student Information From Main list");
            System.out.printf ("║ %-3s %-55s ║%n", "5.", "❌ Remove student by id");
            System.out.printf ("║ %-3s %-56s ║%n", "6.", "✏️  Update student by id");
            System.out.printf ("║ %-3s %-56s ║%n", "7.", "🏫 Count the number of students in each class");
            System.out.printf ("║ %-3s %-56s ║%n", "8.", "📈 Calculate the average gpa for each class");
            System.out.printf ("║ %-3s %-56s ║%n", "9.", "🏆 List student with the highest gpa");
            System.out.printf ("║ %-3s %-56s ║%n", "10.", "🔽 Sort student by descending gpa");
            System.out.printf ("║ %-3s %-56s ║%n", "11.", "🚪 Exit");
            System.out.println("╚═════════════════════════════════════════════════════════════╝");
            System.out.print ("👉 Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "1.", "📊 Check loaded students into file");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.checkLoadStudentInformation();
                    break;
                case 2:
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-53s ║%n", "2.", "🗂️  Display Student Information From File");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.displayStudentInformationFromFile();
                    break;
                case 3:
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-51s ║%n", "3.", "➕ Add a student");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.addNewStudents();
                    break;
                case 4:
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "4.", "📋 Display Student Information From Main list");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.displayStudentInformationFromMainList();
                    break;
                case 5:
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-51s ║%n", "5.", "❌ Remove student by id");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    System.out.print("👉 Enter id of student to remove : ");
                    String id = sc.nextLine();
                    studentServices.RemoveStudentID(id);
                    break;
                case 6 :
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "6.", "✏️  Update student by id");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    System.out.println(" 👉 Enter id of student to update ");
                    String idUpdate = sc.nextLine();
                    studentServices.updateStudentByID(idUpdate);
                    break;
                case 7 :
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "7.", "🏫 Count the number of students in each class");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.countStudent();
                    break;
                case 8 :
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "8.", "📈 Calculate the average gpa for each class");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.averageGpaEachClass();
                    break;
                case 9 :
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "9.", "🏆 List student with the highest gpa");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    System.out.println(studentServices.highestGPAStudent());
                    break;
                case 10 :
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf ("║ %-3s %-52s ║%n", "10.", "🔽 Sort student by descending gpa");
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    studentServices.sortStudentByGPA();
                    break;
                case 11 :
                    System.out.println("Exit");
                    break;
            }
        } while (choice != 11);
    }

}
