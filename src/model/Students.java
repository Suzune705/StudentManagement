package src.model;

public class Students { ;
    private String studentID ;
    private String studentName ;
    private int studentAge ;
    private String studentClass ;
    private double studentGPA ;
    private String studentPhoneNumber ;
    private String studentAddress ;

    public  Students(){

    }
    public Students(String studentID, String studentName, int studentAge, String studentClass, double studentGPA, String studentPhoneNumber, String studentAddress) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentClass = studentClass;
        this.studentGPA = studentGPA;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentAddress = studentAddress;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public double getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public String toString(){
        return this.studentID + "," + this.studentName + "," + this.studentAge + "," + this.studentClass + "," + this.studentGPA + "," + this.studentPhoneNumber + "," + this.studentAddress;
    }
}
