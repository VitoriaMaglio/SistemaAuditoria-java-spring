package com.project.auditsystem.exception;

public class UserInactiveException extends RuntimeException {

    public UserInactiveException() {
        super("User is inactive.");

    }

    public UserInactiveException(String message) {
        super(message);
    }
}
