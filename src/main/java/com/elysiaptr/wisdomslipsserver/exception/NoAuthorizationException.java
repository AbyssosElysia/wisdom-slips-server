package com.elysiaptr.wisdomslipsserver.exception;

public class NoAuthorizationException extends RuntimeException {
    public NoAuthorizationException(String message) {
        super(message);
    }
}
