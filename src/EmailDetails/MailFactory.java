package EmailDetails;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailFactory {
    public static Mail createNormalMail(String emailAddress){
        return new NormalMail().setTo(emailAddress).setSubject().setMessage();
    }

    public static Mail createBirthdayMail(String type,String emailAddress){
        switch (type){
            case "Personal" -> {return new PersonalBirthdayMail().setTo(emailAddress).setSubject().setMessage();}
            case "Official_Friend" -> {return new OfficialFriendMail().setTo(emailAddress).setSubject().setSubject();}
            default-> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
    public static boolean isNotValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
            System.out.println("Invalid Email Alert : "+email);
        }
        return !result;
    }
}
