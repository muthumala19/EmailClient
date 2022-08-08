package EmailDetails;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
public class EmailFactory {
    public static Email createBirthDayEmail(String date,String to){
        return new Email().setBirthdayMessage(true).setTo(to).setMessage(date);
    }
    public static Email createNormalEmail(String to){
        return new Email().setTo(to).setSubject().setMessage();
    }
    public static boolean isNotValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }
        if(!result) System.out.println("Invalid Email.!");
        return !result;
    }
}