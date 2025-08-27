package src.services;

import src.data.LoadStudentInformation;
import src.model.Students;
import src.util.InvalidUserInputException;
import src.util.Validator;

import java.util.*;

public class StudentServices implements IStudentServices {

    Scanner sc = new Scanner(System.in);
    Students students = new Students();
    HashMap<String, Students> mapSV = new HashMap<>();
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
        students = new Students(id, newName, age, phone, address ,nameClass, gpa);
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
    // count the number of students in each class base on frequent appearance
    @Override
    public void countStudent() {
        HashMap<String, Integer> map = new HashMap<>();
        for(Students s : studentMainList()){
            if (map.containsKey(s.getStudentClass())) {
                 int tmp = map.remove(s.getStudentClass()); // remove the duplicate value and return the key of removed value
                 map.put(s.getStudentClass(), tmp + 1); // put removed value with new frequency
            }
            else {
                map.put(s.getStudentClass(), 1); // default class has 1 student
            }
        }

        map.forEach((key,value)->{
            System.out.println("class: " + key + " number: " + value);
        });

    }

    @Override
    public void averageGpaEachClass() {
        Map<String, Map<String, Double>> outer = new HashMap<>();
        for(Students s : studentMainList()){
           outer.putIfAbsent(s.getStudentClass(), new HashMap<>()); // if map have not StudentClass , add it into map and empty child map
           Map<String, Double> inner = outer.get(s.getStudentClass()); //  refer the same child map to memory area that parent map points to
           inner.put("sum", inner.getOrDefault("sum",0.0) + s.getStudentGPA());
           inner.put("count", inner.getOrDefault("count", 0.0) + 1);
        }

        for(Map.Entry<String, Map<String, Double>> entry : outer.entrySet()){
            String classcode = entry.getKey();
            double sum = entry.getValue().get("sum");
            double cnt = entry.getValue().get(("count"));
            double avg = sum/cnt ;
            System.out.printf("%s -> GPA TB = %.2f%n", classcode, avg);
        }
    }


    // display student from a list having all students

    @Override
    public void displayStudentInformationFromMainList() {
        studentMainList().forEach(s -> {
            System.out.println(s);
        });
    }

    @Override
    public void updateStudentByID(String id) {
        boolean found = false ;
        Students studentFounded = null ;
        for(Students s : studentMainList()){
            mapSV.put(s.getID(), s);
        }
        for(Map.Entry<String, Students> entry : mapSV.entrySet()){
            String idFound = entry.getKey();
            if(idFound.equalsIgnoreCase(id)){
                System.out.println("founded Student ");
                found = true;
                studentFounded = entry.getValue();
            }
        }
        if(found){
            System.out.println("Enter a field you want update  :");
            System.out.println("---------------------Name--------------------");
            System.out.println("---------------------Age---------------------");
            System.out.println("--------------------Class--------------------");
            System.out.println("--------------------GPA-----------------------");
            System.out.println("-----------------PhoneNumber------------------");
            System.out.println("------------------Address--------------------");
            System.out.println("---------------------Exit-------------------");
            String field = sc.nextLine().toLowerCase().trim();
            switch (field){
                case "name" :
                    System.out.print("Enter newName : ");
                    String newName = sc.nextLine() ;
                    studentFounded.setName(newName);
                    System.out.println("update name student successfully");
                    break;
                case "age" :
                    System.out.print("Enter newAge :");
                    int newAge = sc.nextInt();
                    sc.nextLine(); // remove space
                    studentFounded.setAge(newAge);
                    break;
                case "class":
                    System.out.print("Enter newClass");
                    String newClass = sc.nextLine();
                    studentFounded.setStudentClass(newClass);
                    System.out.println("update class student done");
                    break;
                case "gpa":
                    System.out.print("Enter newGPA");
                    double newGpa = sc.nextDouble();
                    sc.nextLine();
                    studentFounded.setStudentGPA(newGpa);
                    System.out.println("update gpa student done!!");
                    break;
                case "phone" :
                    System.out.print("Enter newPhone");
                    String newPhone = sc.nextLine();
                    studentFounded.setPhoneNumber(newPhone);
                    System.out.println("update phone student done!!!");
                    break ;
                case "address":
                    System.out.print("Enter newAddress");
                    String newAddress = sc.nextLine();
                    studentFounded.setAddress(newAddress);
                    System.out.println("update address student done!!");
                    break;
                case "exit" :
                    break;
           }
        }
    }
}
