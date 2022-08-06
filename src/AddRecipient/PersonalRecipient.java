package AddRecipient;

public class PersonalRecipient implements Recipient {
    private final String type = "Personal";
    private  String name;
    private  String email;
    private  String nickName;
    private String birthDay;
    private String record;

    @Override
    public Recipient setName(String name) {
        this.name=name;
        return this;
    }
    @Override
    public Recipient setNickName(String nickName) {
        this.nickName=nickName;
        return this;
    }
    @Override
    public Recipient setEmail(String email) {
        this.email=email;
        return this;
    }
    @Override
    public Recipient setBirthDay(String birthDay) {
        this.birthDay=birthDay;
        return this;}
    @Override
    public Recipient setDesignation(String designation) {
        return null;
    }

    @Override
    public String getName() {return this.name;}
    @Override
    public String getEmail() {return this.email;}
    @Override
    public String getType() {return this.type;}
    @Override
    public String getNickName() {return this.nickName;}
    @Override
    public String getBirthDay() {return this.birthDay; }
    @Override
    public String getDesignation() {return null;}
    @Override
    public String getData() {
        if (this.record==null)this.record=this.type+" : "+this.name+","+this.nickName+","+this.email+","+this.birthDay;
        return record;
    }


//    public String getBirthDayMessage() {
//        return null;
//    }
}