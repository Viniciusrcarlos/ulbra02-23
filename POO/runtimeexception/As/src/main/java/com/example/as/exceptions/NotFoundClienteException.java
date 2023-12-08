package com.example.as.exceptions;



public class NotFoundClienteException extends RuntimeException{

    public NotFoundClienteException() {
        super("Nenhum cliente encontrado.");
    }
}
