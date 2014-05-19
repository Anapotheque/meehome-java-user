package fr.meehome.user.webapp.model;

public class Validation {

    private String header;

    private String message;

    private String type;

    public Validation(String message) {
        this.header = "Validation";
        this.message = message;
        this.type = "panel-success";
    }

    public Validation(String message, String type) {
        this(message);
        this.type = type;
    }

    public Validation(String header, String message, String type) {
        this(message, type);
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
