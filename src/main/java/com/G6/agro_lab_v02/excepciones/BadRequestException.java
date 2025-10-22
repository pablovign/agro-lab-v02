package com.G6.agro_lab_v02.excepciones;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
