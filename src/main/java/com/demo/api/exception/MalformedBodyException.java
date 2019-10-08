package com.demo.api.exception;

public class MalformedBodyException extends RuntimeException {

    public MalformedBodyException() {
    }

    public MalformedBodyException(String message) {
        super(message);
    }

    public MalformedBodyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedBodyException(Throwable cause) {
        super(cause);
    }

    public MalformedBodyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
