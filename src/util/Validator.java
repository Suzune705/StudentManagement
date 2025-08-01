package src.util;

public class Validator {

    public static boolean validateID(String id) throws InvalidUserInputException{
       if(id == null) throw new InvalidUserInputException("ID is not null!!");
       if(id.trim().isEmpty()) throw new InvalidUserInputException("ID is not empty!!");
       if(!id.matches("HE\\d{6}")) throw new InvalidUserInputException("ID must be HE + 6 arbitrary numbers") ;
       return true ;
    }

    public static boolean validateName(String name) throws InvalidUserInputException{
        if(!name.matches("^[\\p{L} ]+$")) throw new InvalidUserInputException("Character must be form a - Z");
        return true ;
    }
    public static  boolean validateAge(int age) throws InvalidUserInputException{
        if(age <= 18 || age >= 26) throw new InvalidUserInputException("Age must be > 18 and < 26");
        return true ;
    }
    public static boolean validateClassName(String nameCLass) throws InvalidUserInputException{
        if(!nameCLass.matches("CTK\\d{2}")) throw new InvalidUserInputException("name class not valid ");
        return  true ;
    }
    public static boolean validateGPA(double gpa) throws InvalidUserInputException{
        if(gpa <= 0 || gpa >= 4) throw  new InvalidUserInputException("GPA not valid");
        return  true ;
    }
    public static  boolean validatePhoneNumber(String phone) throws InvalidUserInputException{
        if(!phone.matches("0\\d{9}") || phone.isEmpty()) throw new InvalidUserInputException("phone not valid");
        return true ;
    }
    public static boolean validateAddress(String address) throws  InvalidUserInputException{
        if(address.length() <= 5 || address.length() >= 20) throw new InvalidUserInputException("address not valid");
        return true ;
    }
}
