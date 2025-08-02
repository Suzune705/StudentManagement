package src.model;

public class Person {
    private String personID;
    private String personName ;
    private double age ;
    private String phoneNumber ;
    private String address ;

    public Person() {
    }

    public Person(String personID, String personName, double age , String phoneNumber, String address) {
        this.personID = personID;
        this.personName = personName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getID() {
        return personID;
    }

    public void setID(String personID) {
        this.personID = personID;
    }

    public String getName() {
        return personName;
    }

    public void setName(String personName) {
        this.personName = personName;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personID='" + personID + '\'' +
                ", personName='" + personName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
