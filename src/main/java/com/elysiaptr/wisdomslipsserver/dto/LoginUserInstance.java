package com.elysiaptr.wisdomslipsserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 使用SecurityContext保存的登录对象
 *
 * @author ElysiaPtr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserInstance {
    private String username;
    private String password;
    private Long id;
}
