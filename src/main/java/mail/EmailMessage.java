package mail;

public class EmailMessage {

    private String to = null;
    private String from = null;
    private String subject = null;
    private String message = null;
    private int messageType = TEXT_MSG;
    public static final int HTML_MSG = 1;
    public static final int TEXT_MSG = 2;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
