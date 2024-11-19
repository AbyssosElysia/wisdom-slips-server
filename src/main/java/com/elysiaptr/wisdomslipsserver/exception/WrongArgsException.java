package com.elysiaptr.wisdomslipsserver.exception;

/**
 * 异常类，表示变量错误
 *
 * @author ElysiaPtr
 */
public class WrongArgsException extends RuntimeException {
    public WrongArgsException(String message) {
        super(message);
    }
}
