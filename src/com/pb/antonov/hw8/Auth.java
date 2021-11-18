package com.pb.antonov.hw8;

import java.util.regex.Pattern;

public class Auth {

    private String login;
    private String password;

    public boolean signUp(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        System.out.println("Signing up...");

        if (!checkLoginRequirements(login)) {
            throw new WrongLoginException("Login requirements are not met.");
        }

        if (!checkPasswordRequirements(password)) {
            throw new WrongPasswordException("Password requirements are not met.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and Confirm password are not the same");
        }

        this.login = login;
        this.password = password;
        return true;
    }

    public boolean signIn(String login, String password) throws WrongLoginException {
        System.out.println("Logging in...");
        if(this.login == null){
            throw new WrongLoginException("User not found!");
        }

        if (this.login.equals(login) && this.password.equals(password)) {
            return true;
        } else {
            throw new WrongLoginException("Wrong Credentials");
        }
    }

    private boolean checkPasswordRequirements(String password) {
        boolean match = Pattern.matches("[a-zA-Z0-9_]{5,}", password);
        return match;
    }

    private boolean checkLoginRequirements(String login) {
        boolean match = Pattern.matches("[a-zA-Z0-9]{5,20}", login);
        return match;
    }

    public String getLogin() {
        return login;
    }
}
