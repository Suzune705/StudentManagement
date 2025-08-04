package src.services;

import src.model.Students;

import java.util.List;

public interface IStudentServices {

    // CRUD Student
    void checkLoadStudentInformation();
    void displayStudentInformationFromFile();
    void displayStudentInformationFromMainList();
    void addNewStudents() ;
    void RemoveStudentID(String id);
    void countStudent();
    void updateStudentByID(String id) ;


    // Check load data
    boolean confirmAddStudent(String tmp);
    List<Students> studentMainList();
    List<Students> studentListFromFile();

}
