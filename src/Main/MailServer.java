package Main;

import EmailDetails.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailServer {


    public static void mailServer(Mail email, String recipients) {

        final String username = "muthumalatestmail@gmail.com";
        final String password = "dmuhwiqzfnpoeihx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("muthumalatestmail@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            message.setSubject(email.getSubject());
            message.setText(email.getMessage());
            Transport.send(message);
//            System.out.println("Done");
        } catch (MessagingException e) {
//            e.printStackTrace();
            System.out.println("Error Occurred.!");
        }
    }

}