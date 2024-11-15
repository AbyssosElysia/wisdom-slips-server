package com.elysiaptr.wisdomslipsserver.handler;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import com.elysiaptr.wisdomslipsserver.exception.WrongPasswordException;
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
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(AuthenticationException.class)
    public ApiResponse<String> handleAuthenticationException(AuthenticationException e) {
        log.error("身份验证失败: {}", e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.AUTHENTICATION_EXCEPTION);
    }

    /**
     * 捕获密码错误异常
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(WrongPasswordException.class)
    public ApiResponse<String> WrongPasswordException(WrongPasswordException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.WRONG_PASSWORD_EXCEPTION);
    }

    /**
     * 捕获运行时异常
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
     * @param e 异常
     * @return 响应体
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(ErrorConstant.EXCEPTION);
    }
}
