package com.interview.api.exception.pack;

public class PackNotFoundException extends RuntimeException {
    public PackNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }
    public PackNotFoundException(String msg) {
        super(msg);
    }

    public PackNotFoundException() {super();}
}
