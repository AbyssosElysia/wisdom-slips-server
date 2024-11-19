package com.elysiaptr.wisdomslipsserver.controller;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.dto.requestbody.UsernamePasswordLogin;
import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import com.elysiaptr.wisdomslipsserver.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录控制器
 *
 * @author ElysiaPtr
 */
@RestController
@RequestMapping("/api/login")
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    /**
     * 用户名密码登录
     *
     * @param usernamePasswordLogin 密码登录请求体
     * @return jwt
     */
    @PostMapping("/username")
    public ApiResponse<String> loginByUsername(@RequestBody UsernamePasswordLogin usernamePasswordLogin) {
        String jwt = userLoginService.loginByPassword(usernamePasswordLogin.getUsername(), usernamePasswordLogin.getPassword());
        if (StringUtils.hasLength(jwt)) {
            return ApiResponse.success(jwt);
        }
        return ApiResponse.error(ErrorConstant.LOGIN_FAILED);
    }

}
