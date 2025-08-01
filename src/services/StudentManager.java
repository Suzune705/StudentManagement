package src.services;

import src.data.LoadStudentInformation;
import src.model.Students;

import java.io.File;
import java.util.* ;
public class StudentManager {
    private static StudentManager instance  ;
    private List<Students> studentsList ;  // store data into cache
    private final String filePath = "src/data/StudentInformation.txt";
    private StudentManager(){   // private cannot create new StudentManger outside
        loadStudentsFromFile();
    }


    public static synchronized StudentManager getInstance(){
        if(instance == null){
            instance = new StudentManager();
        }
        return instance ;
    }
    private void loadStudentsFromFile(){
        File file = new File(filePath);
        // load data and push into studentList
        this.studentsList = LoadStudentInformation.loadInfo(file);
        System.out.println("Loaded" +  " " + studentsList.size()  + " "+ "student from file");
    }

    public List<Students> getStudents(){
        return studentsList ;
    }

}

