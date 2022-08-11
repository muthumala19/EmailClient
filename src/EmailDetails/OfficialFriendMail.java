package EmailDetails;

public class OfficialFriendMail implements Mail{
    private String to;
    private String subject;
    private String message;


    @Override
    public Mail setSubject() {
        this.subject="Birthday Wishes.!";
        return this;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public Mail setMessage() {
        this.message="Wish you a Happy Birthday";
        return this;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Mail setTo(String to) {
        this.to=to;
        return this;
    }

    @Override
    public String getTo() {
        return this.to;
    }
}
