package EmailDetails;

import java.util.Scanner;

public class NormalMail implements Mail{
    private String to;
    private String subject;
    private String message;
    private static final Scanner scanner=new Scanner(System.in);

    @Override
    public Mail setSubject() {
        System.out.print("Enter Subject : ");
        this.subject= scanner.nextLine();
        return this;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public Mail setMessage() {
        System.out.print("Enter Message : ");
        this.message=scanner.nextLine();
        return this;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Mail setTo(String to) {
        this.to= to;
        return this;
    }

    @Override
    public String getTo() {
        return this.to;
    }
}
