package AddRecipient;

public class RecipientFactory {

    public static Recipient createRecipient(String[] details) {

        switch (details[0].toLowerCase()) {

            case "personal":

                return new PersonalRecipient()
                        .setName(details[1])
                        .setEmail(details[2])
                        .setNickName(details[3])
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
