package com.interview.api.exception.link;

public class InvalidUrlFormatException extends RuntimeException{
    public InvalidUrlFormatException(String msg, Throwable e) {
        super(msg, e);
    }

    public InvalidUrlFormatException(String msg) {
        super(msg);
    }

    public InvalidUrlFormatException() {super();}
}
