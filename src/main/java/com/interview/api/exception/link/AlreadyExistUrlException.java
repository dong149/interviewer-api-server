package com.interview.api.exception.link;

public class AlreadyExistUrlException extends RuntimeException{
    public AlreadyExistUrlException(String msg, Throwable e) {
        super(msg, e);
    }

    public AlreadyExistUrlException(String msg) {
        super(msg);
    }

    public AlreadyExistUrlException() {super();}
}
