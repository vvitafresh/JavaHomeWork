package com.pb.antonov.hw8;

public class WrongPasswordException extends Exception {
    private String message;
    static final String defaultMessage = "Wrong Password Exception";

    public WrongPasswordException() {
        super(defaultMessage);
        this.message = defaultMessage;
    }

    public WrongPasswordException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
