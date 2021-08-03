package com.interview.api.exception.link;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }

    public LinkNotFoundException(String msg) {
        super(msg);
    }

    public LinkNotFoundException() {super();}
}
