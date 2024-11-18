package com.elysiaptr.wisdomslipsserver.exception;

public class WrongTokenException extends RuntimeException{
    public WrongTokenException(String message) {
        super(message);
    }
}
