package com.project.auditsystem.exception;

public class RegisteredEmailException extends RuntimeException {

    public RegisteredEmailException() {
        super("Email is already registered.");
    }


}
