package ClientDetails;

import EmailDetails.Mail;

import java.io.Serializable;

public class MailData implements Serializable {
    private  final String date;
    private  final Mail mailAddress;
    private String record;

    public MailData(String date, Mail mailAddress)  {
        this.date = date;
        this.mailAddress = mailAddress;
        setRecord();
    }

    public String getDate() {
        return date;
    }

    public Mail getEmail() {
        return mailAddress;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord() {
        this.record = "Sub : "+mailAddress.getSubject()+" , message : "+mailAddress.getMessage() + "-"+RecipientData.author;
    }



}
