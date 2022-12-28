package com.love2code.accountopeningtool.Exception;

public class CustomerExistException extends RuntimeException{

    public CustomerExistException(String message) {
        super(message);
    }

    public CustomerExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerExistException(Throwable cause) {
        super(cause);
    }

    protected CustomerExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
