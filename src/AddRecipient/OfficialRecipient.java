package AddRecipient;

import java.time.LocalDate;

public class OfficialRecipient implements Recipient {

    private final String type = "Official";
    private String name;
    private String email;
    private String designation;
    private String record;

    @Override
    public Recipient setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Recipient setNickName(String nickName) {
        return null;
    }

    @Override
    public Recipient setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public Recipient setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    @Override
    public Recipient setBirthDay(String birthDay) {
        return this;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public LocalDate getBirthDay() {
        return null;
    }

    @Override
    public String getData() {
        if (this.record == null)
            this.record = this.type + " : " + this.name + "," + this.email + "," + this.designation;
        return this.record;
    }
}