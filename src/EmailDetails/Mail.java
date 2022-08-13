package EmailDetails;

import java.io.Serializable;

public interface Mail extends Serializable {

    Mail setSubject();

    String getSubject();

    Mail setMessage();

    String getMessage();

    Mail setTo(String to);

    String getTo();


}
