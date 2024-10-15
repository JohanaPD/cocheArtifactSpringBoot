package com.project_coche.exceptions;

public class UnauthorizadException extends Throwable{
    public UnauthorizadException(){
        super("Usuario no autorizado");
    }
}
