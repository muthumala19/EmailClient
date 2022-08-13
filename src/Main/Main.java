package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Operations.clearData();
        Operations.loadData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter option type:\s
                1 - Adding a new recipient
                2 - Sending an email
                3 - Printing out all the recipients who have birthdays
                4 - Printing out details of all the emails sent
                5 - Printing out the number of recipient objects in the application""");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> Operations.createRecipient();
            case 2 -> Operations.sendNormalMail();
            case 3 -> Operations.printBirthDays();
            case 4 -> Operations.showSendMails();
            case 5 -> Operations.getNoOfRecipient();
        }
        Operations.sendBirthdayMail();
        Operations.releaseData();
    }
}