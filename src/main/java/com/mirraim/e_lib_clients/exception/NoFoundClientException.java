package com.mirraim.e_lib_clients.exception;

public class NoFoundClientException extends RuntimeException {

    public NoFoundClientException() {
        super("Клиент не найден");
    }
}
