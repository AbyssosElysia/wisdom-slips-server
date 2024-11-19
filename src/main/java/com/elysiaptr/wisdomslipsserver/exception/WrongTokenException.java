package com.elysiaptr.wisdomslipsserver.exception;

/**
 * 异常类，表示Authorization请求头token错误
 *
 * @author ElysiaPtr
 */
public class WrongTokenException extends RuntimeException {
    public WrongTokenException(String message) {
        super(message);
    }
}
