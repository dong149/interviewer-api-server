package com.interview.api.exception.category;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }

    public CategoryNotFoundException(String msg) {
        super(msg);
    }

    public CategoryNotFoundException() {super();}
}
