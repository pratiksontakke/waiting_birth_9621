package com.masai.exception;

public class BankAccountException extends Exception{
    public BankAccountException() {
    }

    public BankAccountException(String message) {
        super(message);
    }
}
