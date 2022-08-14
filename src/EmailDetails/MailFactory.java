package EmailDetails;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailFactory {
    public static Mail createNormalMail(String emailAddress) {
        return new NormalMail().setTo(emailAddress).setSubject().setMessage();
    }

    public static Mail createBirthdayMail(String type, String emailAddress) {
        switch (type) {
            case "Personal" -> {
                return new PersonalBirthdayMail().setTo(emailAddress).setSubject().setMessage();
            }
            case "Office_friend" -> {
                return new OfficeFriendMail().setTo(emailAddress).setSubject().setMessage();
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    //check whether the given email address is valid or not
    public static boolean isNotValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
            System.out.println("Invalid Email Alert : " + email);
        }
        return !result;
    }
}
