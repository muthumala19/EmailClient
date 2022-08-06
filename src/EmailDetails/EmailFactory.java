package EmailDetails;

public class EmailFactory {
    public static Email createBirthDayEmail(String date,String to){
        return new Email().setBirthdayMessage(true).setTo(to).setMessage(date);
    }
    public static Email createNormalEmail(String to){
        return new Email().setTo(to).setSubject().setMessage();
    }
}
