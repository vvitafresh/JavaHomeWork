package com.pb.antonov.hw8;

public class WrongLoginException extends Exception {
    private String message;
    static final String defaultMessage = "Wrong Login Exception";

    public WrongLoginException() {
        super(defaultMessage);
        this.message = defaultMessage;
    }

    public WrongLoginException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
