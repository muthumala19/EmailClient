package AddRecipient;

import java.io.Serializable;
import java.time.LocalDate;

public interface Recipient extends Serializable {
    String getEmail();

    String getType();

    LocalDate getBirthDay();

    String getData();

    Recipient setEmail(String email);

    Recipient setName(String name);

    Recipient setNickName(String nickName);

    Recipient setBirthDay(String birthDay);

    Recipient setDesignation(String designation);

}
