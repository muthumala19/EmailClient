package ClientDetails;

import AddRecipient.Recipient;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipientData {

    public static String today="";
    public static String author="pasindu muthumala";
    public static ArrayList<String> recipientRecords=new ArrayList<>();
    public static HashMap<String,Recipient> recipients =new HashMap<>();
    public static HashMap<String,ArrayList<Recipient>> birthDayRecords =new HashMap<>();
    public static HashMap<String,ArrayList<EmailData>> sentMails =new HashMap<>();
}
