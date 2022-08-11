package EmailDetails;

import java.util.Scanner;

public class PersonalBirthdayMail implements Mail{
    private String to;
    private String subject;
    private String message;
//    private static Scanner scanner=new Scanner(System.in);

    @Override
    public Mail setSubject() {
        this.subject="Birthday Wishes.!";
        return this;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public Mail setMessage() {
        this.message="hugs and love on your birthday";
        return this;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Mail setTo(String to) {
        this.to=to;
        return this;
    }

    @Override
    public String getTo() {
        return this.to;
    }
}
