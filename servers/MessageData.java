package servers;

import java.io.Serializable;
import java.util.Date;

public class MessageData implements Serializable {

    private String userName;
    private String messageText;
    private Date sentDate;

    public MessageData() {
    }

    public MessageData(String userName, String messageText) {
        this.userName = userName;
        this.messageText = messageText;
        this.sentDate = new Date();
    }

    @Override
    public String toString() {
        return userName + ": " + messageText + " at " + sentDate;
    }
}
