import AddRecipient.Recipient;
import AddRecipient.RecipientFactory;
import ClientDetails.DataManager;
import ClientDetails.RecipientData;
import ClientDetails.UserData;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Operations {
    public static void createRecipient() {
        Recipient user = RecipientFactory.createRecipient();



        if (!RecipientData.birthDayRecords.containsKey(user.getBirthDay()))RecipientData.birthDayRecords.put(user.getBirthDay(), new ArrayList<>() );

        RecipientData.birthDayRecords.get(user.getBirthDay()).add(user);
        DataManager.writeFile("clientList.txt", user.getData());
        RecipientData.recipientRecords.add(user.getData());



    }

    public static void loadData() {
        RecipientData.recipientRecords = DataManager.readFile("clientList.txt");
        RecipientData.recipients = (HashMap<String, Recipient>) DataManager.deserializeFile("recipients.ser");
        RecipientData.birthDayRecords = (HashMap<String, ArrayList<Recipient>>) DataManager.deserializeFile("birthdays.ser");
        RecipientData.sentMails = (HashMap<String, ArrayList<UserData>>) DataManager.deserializeFile("userData.ser");

    }

    public static void releaseData() {
        DataManager.serializeFile("recipients.ser", RecipientData.recipients);
        DataManager.serializeFile("birthdays.ser", RecipientData.birthDayRecords);
        DataManager.serializeFile("userData.ser", RecipientData.sentMails);

    }
}
