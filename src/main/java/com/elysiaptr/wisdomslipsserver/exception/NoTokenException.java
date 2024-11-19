package com.elysiaptr.wisdomslipsserver.exception;

/**
 * 异常类，表示没有携带Authorization请求头
 *
 * @author ElysiaPtr
 */
public class NoTokenException extends RuntimeException {
    public NoTokenException(String message) {
        super(message);
    }
}
