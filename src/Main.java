import AddRecipient.Recipient;
import ClientDetails.DataManager;
import ClientDetails.RecipientData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Operations.loadData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                Operations.createRecipient();
                break;
            case 2:
                // input format - email, subject, content
                // code to send an email
                break;
            case 3:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print recipients who have birthdays on the given date
                break;
            case 4:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print the details of all the emails sent on the input date

                System.out.println("Enter date : ");
                for (Recipient r: RecipientData.birthDayRecords.get(scanner.next()) )System.out.println(r.getData());
                break;
            case 5:
                // code to print the number of recipient objects in the application
                break;



//         start email client
//         code to create objects for each recipient in clientList.txt
//         use necessary variables, methods and classes

        }
        Operations.releaseData();
    }
}


// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
