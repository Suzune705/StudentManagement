package src.services;

import src.data.LoadStudentInformation;
import src.model.Students;

import java.io.File;
import  java.util.* ;
public class StudentList {

    public static List<Students> studentMainList(){
        return StudentManager.getInstance().getStudents(); // take data Student from Cache
    }

}
