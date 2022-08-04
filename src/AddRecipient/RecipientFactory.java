package AddRecipient;

import java.util.Scanner;

public class RecipientFactory {
    private String type;
    private String name;
    private String email;
    private String nickName = null;
    private String designation = null;
    private String birthDay = null;


    public Recipient createRecipient() {
        Scanner scan = new Scanner(System.in);

        switch (scan.next().toLowerCase()) {
            
            case "personal":

                System.out.print("Enter recipient type : ");
                this.type = scan.nextLine();

                System.out.print("Enter recipient name : ");
                this.name = scan.nextLine();

                System.out.print("Enter recipient email : ");
                this.email = scan.nextLine();
                System.out.print("Enter recipient nick name : ");

                this.nickName = scan.nextLine();
                System.out.print("Enter recipient birth day : ");

                this.birthDay = scan.nextLine();
                return new PersonalRecipient(name, nickName, email, birthDay);

            case "official":

                System.out.print("Enter recipient type : ");
                this.type = scan.nextLine();

                System.out.print("Enter recipient name : ");
                this.name = scan.nextLine();

                System.out.print("Enter recipient email : ");
                this.email = scan.nextLine();

                System.out.print("Enter recipient designation : ");
                this.designation = scan.nextLine();

                return new OfficialRecipient(name, email, designation);

            case "official_personal":
                System.out.print("Enter recipient type : ");
                this.type = scan.nextLine();

                System.out.print("Enter recipient name : ");
                this.name = scan.nextLine();

                System.out.print("Enter recipient email : ");
                this.email = scan.nextLine();

                System.out.print("Enter recipient designation : ");
                this.designation = scan.nextLine();

                return null;

            default:
                return null;

        }

    }

}
