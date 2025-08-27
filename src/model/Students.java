package src.model;

import src.services.IStudentServices;

public class Students extends  Person{ ;


    private String studentClass ;
    private double studentGPA ;
    public  Students(){

    }

    public Students(String personID, String personName, double age, String phoneNumber , String address , String studentClass, double studentGPA) {
        super(personID, personName, age, phoneNumber,  address);
        this.studentClass = studentClass ;
        this.studentGPA = studentGPA ;
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

    @Override
    public void setName(String personName) {
        super.setName(personName);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setAge(double age) {
        super.setAge(age);
    }

    @Override
    public double getAge() {
        return super.getAge();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }


    @Override
    public String  toString(){
        return getID() + "," + getName() + "," + getAge() + "," + getPhoneNumber() + "," + getAddress() + "," + getStudentClass() + ","+  getStudentGPA() ;
    }
}
