package ClientDetails;

import EmailDetails.Mail;

import java.io.Serializable;

public class MailData implements Serializable {
    private final Mail mailAddress;
    private String record;

    public MailData( Mail mailAddress) {
        this.mailAddress = mailAddress;
        setRecord();
    }

    public String getRecord() {
        return record;
    }

    public void setRecord() {
        this.record = "Sub : " + mailAddress.getSubject() + " , message : " + mailAddress.getMessage() + "-" + RecipientData.author;
    }


}
