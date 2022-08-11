package Main;

import AddRecipient.Recipient;
import AddRecipient.RecipientFactory;
import ClientDetails.DataManager;
import ClientDetails.MailData;
import ClientDetails.RecipientData;

import EmailDetails.Mail;
import EmailDetails.MailFactory;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Operations {
    private static final Scanner scanner = new Scanner(System.in);

    public static void clearData() {
        releaseData();
    }

    public static void getNoOfRecipient() {
        System.out.println(RecipientData.recipients.size());
    }

    public static void loadData() {
        RecipientData.recipientRecords = DataManager.readFile("clientList.txt");
        RecipientData.recipients = DataManager.deserializeFile("recipients.ser");
        RecipientData.birthDayRecords = DataManager.deserializeFile("birthdays.ser");
        RecipientData.sentMails = DataManager.deserializeFile("userData.ser");
    }

    public static void releaseData() {
        DataManager.serializeFile("recipients.ser", RecipientData.recipients);
        DataManager.serializeFile("birthdays.ser", RecipientData.birthDayRecords);
        DataManager.serializeFile("userData.ser", RecipientData.sentMails);
    }

    public static void printBirthDays() {
        System.out.println("Enter date : ");
        String date = scanner.next();
        if (!RecipientData.birthDayRecords.containsKey(date))System.out.println("No current recipients have birthdays on that day");
        else for (Recipient details : RecipientData.birthDayRecords.get(date)) System.out.println(details.getData());
    }

    private static void update(Recipient user) {
        if (!RecipientData.birthDayRecords.containsKey(user.getBirthDay()))RecipientData.birthDayRecords.put(user.getBirthDay(), new ArrayList<>());
        RecipientData.recipients.put(user.getEmail(), user);
        RecipientData.birthDayRecords.get(user.getBirthDay()).add(user);
        DataManager.writeFile("clientList.txt", user.getData());
        RecipientData.recipientRecords.add(user.getData());
    }

    public static void sendBirthdayMail() {
        if (RecipientData.birthDayRecords.get(RecipientData.today) == null) return;
        for (Recipient r : RecipientData.birthDayRecords.get(RecipientData.today)) {
            Mail e = MailFactory.createBirthdayMail(r.getType(), r.getEmail());
            updateEmailList(e, r.getEmail());
        }
    }

    public static void sendNormalMail() {
        System.out.print("Enter Recipients : ");
        String to = scanner.nextLine();
        String[] toList = to.strip().split("[, ]+");
        for (String email : toList) {
            if (MailFactory.isNotValidEmailAddress(email)) return;
            Mail e = MailFactory.createNormalMail(to);
            updateEmailList(e, to);
        }
    }

    private static void updateEmailList(Mail e, String to) {
        if (!RecipientData.sentMails.containsKey(RecipientData.today))RecipientData.sentMails.put(RecipientData.today, new ArrayList<>());
        RecipientData.sentMails.get(RecipientData.today).add(new MailData(RecipientData.today, e));
        MailServer.mailServer(e, to);
    }

    public static void showSendMails() {
        System.out.println("Enter date : ");
        String date = scanner.next();
        for (MailData e : RecipientData.sentMails.get(date)) System.out.println(e.getRecord());
    }

    public static void createRecipient() {
        System.out.print("Enter recipient : \nEx : \n     Personal : <name> <email address> <nick name> <birthday>\n     Official : <name> <email address> <designation>\n     Official_Friend : <name> <email address> <designation> <birthday>\n");
        String[] details = scanner.nextLine().strip().split("[,: ]+");
        if (MailFactory.isNotValidEmailAddress(details[2])) return;
        if (RecipientData.recipients.containsKey(details[2])) {
            System.out.println("Already exist user.!");
            return;
        }
        Recipient user = RecipientFactory.createRecipient(details);
        if (user != null) update(user);
    }
}
