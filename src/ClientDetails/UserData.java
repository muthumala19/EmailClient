package ClientDetails;

import AddRecipient.Recipient;

public class UserData {
    private final Recipient user; //userId:email , record:record
    private final String sentMessage;

    public UserData(Recipient user, String sentMessage) {
        this.user = user;
        this.sentMessage = sentMessage;
    }
}
