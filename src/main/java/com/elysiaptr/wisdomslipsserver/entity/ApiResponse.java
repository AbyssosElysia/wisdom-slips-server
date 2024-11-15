package com.elysiaptr.wisdomslipsserver.entity;

import com.elysiaptr.wisdomslipsserver.constant.ResponseConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 *
 * @param <T> 类型
 * @author ElysiaPtr
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private int code;
    private String message;
    private T data;

    /**
     * 构造成功响应
     * @param data 返回数据
     * @return 响应体
     * @param <T> 类型
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResponseConstant.SUCCESS, "Request was successful", data);
    }

    /**
     * 构造失败响应
     * @param message 错误数据
     * @return 响应体
     * @param <T> 类型
     */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(ResponseConstant.ERROR, message, null);
    }
}
