package com.elysiaptr.wisdomslipsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elysiaptr.wisdomslipsserver.dto.LoginUser;
import com.elysiaptr.wisdomslipsserver.dto.LoginUserInstance;
import com.elysiaptr.wisdomslipsserver.entity.SysUser;
import com.elysiaptr.wisdomslipsserver.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 实现用户详情服务接口
 *
 * @author ElysiaPtr
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 根据用户选择
     *
     * @param username the username identifying the user whose data is required.
     * @return 用户详情
     * @throws UsernameNotFoundException 用户名未找到异常
     */
    public UserDetails loadUserByUsername(String username) {
        // 新建包装器
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (sysUser == null) {
            log.warn("Username {} not found", username);
            throw new UsernameNotFoundException(username);
        }
        LoginUserInstance loginUserInstance = new LoginUserInstance();
        BeanUtils.copyProperties(sysUser, loginUserInstance);
        return new LoginUser(loginUserInstance);
    }
}
