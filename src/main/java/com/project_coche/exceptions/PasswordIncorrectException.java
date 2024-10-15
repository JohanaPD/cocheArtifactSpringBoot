package com.project_coche.exceptions;

public class PasswordIncorrectException extends Throwable {
    public PasswordIncorrectException() {
        super("El password no coincide");
    }
}
