package com.elysiaptr.wisdomslipsserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 密码登录请求体
 *
 * @author ElysiaPtr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordLogin {
    private String username;
    private String password;
}
