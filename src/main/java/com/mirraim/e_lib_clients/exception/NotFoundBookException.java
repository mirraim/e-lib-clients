package com.mirraim.e_lib_clients.exception;

public class NotFoundBookException extends RuntimeException{

    public NotFoundBookException() {
        super("У клиента нет доступных книг");
    }
}
