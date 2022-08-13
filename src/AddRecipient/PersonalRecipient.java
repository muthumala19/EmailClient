package AddRecipient;

import Main.Operations;

import java.time.LocalDate;

public class PersonalRecipient implements Recipient {
    private final String type = "Personal";
    private LocalDate formattedBirthday;
    private String name;
    private String email;
    private String nickName;
    private String birthDay;
    private String record;

    @Override
    public Recipient setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Recipient setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Override
    public Recipient setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public Recipient setBirthDay(String birthDay) {
        this.formattedBirthday = LocalDate.parse(birthDay);
        this.birthDay = Operations.dateFormatter("yyyy/MM/dd", this.formattedBirthday);
        return this;
    }

    @Override
    public Recipient setDesignation(String designation) {
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
        return this.formattedBirthday;
    }

    @Override
    public String getData() {
        if (this.record == null)
            this.record = this.type + " : " + this.name + "," + this.nickName + "," + this.email + "," + this.birthDay;
        return this.record;
    }

}