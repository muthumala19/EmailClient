package AddRecipient;

import java.util.Scanner;

public class RecipientFactory {

    public static Recipient createRecipient() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter recipient : \nEx : \n     Personal : <name> <nick name> <email address> <birthday>\n     Official : <name> <email address> <designation>\n     Official_Friend : <name> <email address> <designation> <birthday>\n");
        String[] details = scan.nextLine().strip().split("[,: ]+");

        switch (details[0].toLowerCase()) {

            case "personal":
                return new PersonalRecipient()
                        .setName(details[1])
                        .setNickName(details[2])
                        .setEmail(details[3])
                        .setBirthDay(details[4]);

            case "official":
                return new OfficialRecipient()
                        .setName(details[1])
                        .setEmail(details[2])
                        .setDesignation(details[3]);

            case "official_friend":
                return null;

            default:
                System.out.print("Invalid Recipient Type.! ");
                return null;
        }
    }
}
