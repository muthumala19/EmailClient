package AddRecipient;

public class PersonalRecipient implements Recipient {
    private final String type = "Personal";
    private final String name;
    private final String email;
    private final String nickName;
    private final String birthDay;
    private String record;

    public PersonalRecipient(String name, String nickName, String email, String birthDay) {
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.birthDay = birthDay;
    }


    @Override
    public String getData() {
        this.record=this.type+" : "+this.name+","+this.nickName+","+this.email+","+this.birthDay;
        return record;
    }
}