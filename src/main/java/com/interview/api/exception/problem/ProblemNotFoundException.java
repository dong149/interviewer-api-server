package com.interview.api.exception.problem;

public class ProblemNotFoundException extends  RuntimeException{
    public ProblemNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }
    public ProblemNotFoundException(String msg) {
        super(msg);
    }

    public ProblemNotFoundException() {super();}
}
