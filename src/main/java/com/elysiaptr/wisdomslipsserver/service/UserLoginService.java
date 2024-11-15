package com.elysiaptr.wisdomslipsserver.service;

/**
 * 用户登陆接口
 *
 * @author ElysiaPtr
 */
public interface UserLoginService {
    String loginByPassword(String username, String password);
}
