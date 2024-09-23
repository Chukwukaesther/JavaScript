package com.semicolon.africa.exceptions;

public class UserNotFoundException extends NoteManagementException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
