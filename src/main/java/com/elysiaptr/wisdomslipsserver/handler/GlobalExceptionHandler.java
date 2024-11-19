package com.elysiaptr.wisdomslipsserver.handler;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import com.elysiaptr.wisdomslipsserver.exception.NoTokenException;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;
import com.elysiaptr.wisdomslipsserver.exception.WrongTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author ElysiaPtr
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获身份验证异常
     *
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(AuthenticationException.class)
    public ApiResponse<String> handleAuthenticationException(AuthenticationException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.AUTHENTICATION_EXCEPTION);
    }

    /**
     * 捕获密钥为空异常
     *
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(NoTokenException.class)
    public ApiResponse<String> NoAuthorizationException(NoTokenException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.TOKEN_IS_EMPTY);
    }

    /**
     * 捕获密钥错误异常
     *
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(WrongTokenException.class)
    public ApiResponse<String> WrongTokenException(WrongTokenException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.TOKEN_IS_WRONG);
    }

    /**
     * 变量错误异常
     *
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(WrongArgsException.class)
    public ApiResponse<String> WrongArgsException(WrongArgsException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.RUNTIME_EXCEPTION);
    }

    /**
     * 捕获运行时异常
     *
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<String> handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.RUNTIME_EXCEPTION);
    }

    /**
     * 捕获全局异常
     *
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.EXCEPTION);
    }
}
