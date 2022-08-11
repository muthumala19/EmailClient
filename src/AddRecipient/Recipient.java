package AddRecipient;

import java.io.Serializable;
import java.time.LocalDate;

public interface Recipient extends Serializable {
   String getName();
   String getEmail();
   String getType();
   String getNickName();
   String getBirthDay();
   String getDesignation();
   String getData();

   Recipient setEmail(String email);
   Recipient setName(String name);
   Recipient setNickName(String nickName);
   Recipient setBirthDay(String birthDay);
   Recipient setDesignation(String designation);

}
