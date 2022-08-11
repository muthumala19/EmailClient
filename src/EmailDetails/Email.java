package EmailDetails;

import ClientDetails.RecipientData;

import java.io.Serializable;
import java.util.Scanner;

public class Email implements Serializable {
    private String subject="";
    private String to;
    private String message;
    private boolean isBirthdayMessage = false;
    private static final Scanner scanner=new Scanner(System.in);

    public String getSubject() {return subject;}
    public String getTo() {return to;}
    public String getMessage() {return message;}


    public Email setBirthdayMessage(boolean birthdayMessage) {
        this.isBirthdayMessage = birthdayMessage;
        return this;
    }
    public Email setSubject() {
        System.out.print("Enter Subject : ");
        this.subject = scanner.nextLine();
        return this;
    }

    public Email setTo(String to) {
        this.to = to;
        return this;
    }

    public Email setMessage(String userId) {
        if (isBirthdayMessage) {
            if (RecipientData.recipients
                    .get(userId)
                    .getType()
                    .equalsIgnoreCase("personal")
            )
            {this.message = "hugs and love on your birthday";
            } else {this.message = "Wish you a Happy Birthday";}
        }
        return this;

    }
    public Email setMessage(){
        System.out.print("Enter Message : ");
        this.message=scanner.nextLine();
        return this;
    }


}
