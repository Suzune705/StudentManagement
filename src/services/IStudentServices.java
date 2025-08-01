package src.services;

import src.model.Students;

import java.util.List;

public interface IStudentServices {
    void checkLoadStudentInformation();
    void displayStudentInformationFromFile();
    void displayStudentInformationFromMainList();
    void addNewStudents() ;
    void RemoveStudentID(String id);
    boolean confirmAddStudent(String tmp);
    List<Students> studentMainList();
    List<Students> studentListFromFile();
}
