package src.services;

import src.model.Students;

public class StudentRemover {

    public static void removeStudentByID(String id){
        if(StudentManager.getInstance().getStudents().removeIf(s -> s.getID().equalsIgnoreCase(id))){
            System.out.println("Student removed ");
        }
        else {
            System.out.println("Student id not found");
        }
    }

}
