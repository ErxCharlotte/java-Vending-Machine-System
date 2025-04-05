package RE08_Group3_A2;

import RE08_Group3_A2.User.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class CancelTransaction {
    String dtf;
    String type; // "timeout", "user cancelled", "change not available"
    User user;


    public CancelTransaction(String type, User user) {
        this.type = type;
        this.user = user;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dtf = dateTimeFormatter.format(now);
    }

    public String getDtf() {
        return dtf;
    }

    public void setDtf(String dtf) {
        this.dtf = dtf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
