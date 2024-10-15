package com.project_coche.exceptions;

public class CustomerNotExistException extends Throwable {
    public CustomerNotExistException() {
        super("El usuario no existe");
    }
}
