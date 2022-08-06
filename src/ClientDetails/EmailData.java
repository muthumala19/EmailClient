package ClientDetails;

import EmailDetails.Email;

import java.io.Serializable;

public class EmailData implements Serializable {
    private  final String date;
    private  final Email email;
    private String record;

    public EmailData(String date, Email email)  {
        this.date = date;
        this.email = email;
        setRecord();
    }

    public String getDate() {
        return date;
    }

    public Email getEmail() {
        return email;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord() {
        this.record = "Sub : "+email.getSubject()+" , message : "+email.getMessage() + "-"+RecipientData.author;
    }



}
