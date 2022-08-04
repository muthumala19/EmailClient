package AddRecipient;

public class OfficialRecipient implements Recipient {

    private final String type="Official";
    private final String name;
    private final String email;
    private final String designation;
    private String record;


    public OfficialRecipient(String name, String email, String designation) {
        this.name = name;
        this.email = email;
        this.designation = designation;
    }

    @Override
    public String getData() {
        this.record=this.type+" : "+this.name+","+this.email+","+this.designation;
        return record;
    }
}