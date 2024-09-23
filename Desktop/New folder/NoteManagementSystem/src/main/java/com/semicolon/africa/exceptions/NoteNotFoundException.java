package com.semicolon.africa.exceptions;

public class NoteNotFoundException extends NoteManagementException{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
