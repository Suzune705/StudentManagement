package src.services;

import src.data.LoadStudentInformation;
import src.model.Students;
import src.util.InvalidUserInputException;
import src.util.Validator;

import java.util.List;
import java.util.Scanner;

public class StudentServices implements IStudentServices {

    Scanner sc = new Scanner(System.in);

    // the list includes all students
    @Override
    public List<Students> studentMainList() {
        return StudentList.studentMainList();
    }

    // the list includes all students in File txt
    @Override
    public List<Students> studentListFromFile() {
        return StudentManager.getInstance().getStudents();
    }

    // check a load file
    @Override
    public void checkLoadStudentInformation() {
        List<Students> tmp = studentListFromFile(); // take the data from studentListFromFile
        if (tmp.isEmpty()) {
            System.out.println("Load Failed !!!");
        } else {
            System.out.println("Load Successfully !!!");
        }
    }

    // display student in file txt
    @Override
    public void displayStudentInformationFromFile() {
        List<Students> tmp = studentListFromFile();
        for (Students x : tmp) {
            System.out.println(x);
        }
    }

    // add student and confirm add student into file txt or not
    @Override
    public void addNewStudents() {
        System.out.println("3. Add a student ");
        String id = "" ;
        while(true){
            System.out.print("Enter id :");
            id = sc.nextLine();
            try {
               if(Validator.validateID(id)){
                    break; // if id is valid, break while
               };
            } catch (InvalidUserInputException i) {
                System.out.println(i.getMessage());
            }
        }
        String name = "" ;
        String newName = "";
        while (true) {
            System.out.print("Enter name : ");
            name = sc.nextLine();
            try{
                if(Validator.validateName(name)){
                    String[] tmp2 = name.split("\\s+");
                    for (String x : tmp2) {
                        x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
                        newName += x + " ";
                    }
                    break;
                }
            }catch (InvalidUserInputException i){
                System.out.println(i.getMessage());
            }
        }
        int age;
        while (true) {
            System.out.print("Enter age : ");
            age = sc.nextInt();
            sc.nextLine();
            try {
                if(Validator.validateAge(age)){
                    break; // if id is valid, break while
                };
            } catch (InvalidUserInputException i) {
                System.out.println(i.getMessage());
            }
        }
        String nameClass;
        while (true) {
            System.out.print("Enter class : ");
            nameClass = sc.nextLine();
            try {
                if(Validator.validateClassName(nameClass)){
                    break; // if id is valid, break while
                };
            } catch (InvalidUserInputException i) {
                System.out.println(i.getMessage());
            }
        }
        double gpa;
        while (true) {
            System.out.print("Enter gpa : ");
            gpa = sc.nextDouble();
            sc.nextLine();
            try {
                if(Validator.validateGPA(gpa)){
                    break; // if id is valid, break while
                };
            } catch (InvalidUserInputException i) {
                System.out.println(i.getMessage());
            }
        }
        String phone;
        while (true) {
            System.out.print("Enter phone :");
            phone = sc.nextLine();
            try {
                if(Validator.validatePhoneNumber(phone)){
                    break; // if id is valid, break while
                };
            } catch (InvalidUserInputException i) {
                System.out.println(i.getMessage());
            }
        }
        String address;
        while (true) {
            System.out.print("Enter address :");
            address = sc.nextLine();
            try {
                if(Validator.validateAddress(address)){
                    break; // if id is valid, break while
                };
            } catch (InvalidUserInputException i) {
                System.out.println(i.getMessage());
            }
        }
        Students students = new Students(id, newName, age, nameClass, gpa, phone, address);
        String confirm = sc.nextLine();
        if (confirmAddStudent(confirm)) {
            System.out.println("Do you want to add new student into Main List ? <Yes> or <No>");
            studentMainList().add(students);
            if (studentMainList().isEmpty()) System.out.println("add failed");
            else System.out.println("add successfully");
        }
    }

    //    check confirm add Student
    @Override
    public boolean confirmAddStudent(String tmp) {
        return tmp.equalsIgnoreCase("yes");
    }

    //    remove student by id
    @Override
    public void RemoveStudentID(String id) {
        StudentRemover.removeStudentByID(id);
    }

// display student from a list having all students

    @Override
    public void displayStudentInformationFromMainList() {
        studentMainList().forEach(s -> {
            System.out.println(s);
        });
    }

}
