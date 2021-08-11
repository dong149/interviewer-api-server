package com.interview.api.exception.link;

public class InvalidUrlFormatException extends RuntimeException{

    private static final String ERROR_MSG = "잘못된 URL 형식입니다. 주소를 다시 한 번 확인해 주세요.";
    public InvalidUrlFormatException(String msg, Throwable e) {
        super(msg, e);
    }

    public InvalidUrlFormatException(String msg) {
        super(msg);
    }

    public InvalidUrlFormatException() {super(ERROR_MSG);}
}
