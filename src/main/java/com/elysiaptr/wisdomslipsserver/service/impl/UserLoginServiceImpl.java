package com.elysiaptr.wisdomslipsserver.service.impl;

import com.alibaba.fastjson2.JSON;
import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.dto.LoginUser;
import com.elysiaptr.wisdomslipsserver.service.UserLoginService;
import com.elysiaptr.wisdomslipsserver.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户登陆
 *
 * @author ElysiaPtr
 */
@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 使用密码登录
     *
     * @param username 姓名
     * @param password 密码
     * @return jwt令牌
     */
    public String loginByPassword(String username, String password) {
        log.debug("loginByPassword: username={}, password={}", username, passwordEncoder.encode(password));

        // 封装Authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        // 校验
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        // 如果authentication为空
        if (Objects.isNull(authentication)) {
            log.warn("User {} login failed", username);
            throw new RuntimeException(ErrorConstant.LOGIN_FAILED);
        }
        // 放入用户信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成jwt并转化为字符串
        String loginUserString = JSON.toJSONString(loginUser);
        // 生成jwt令牌
        return jwtUtil.generateJWT(loginUserString, null);
    }
}
