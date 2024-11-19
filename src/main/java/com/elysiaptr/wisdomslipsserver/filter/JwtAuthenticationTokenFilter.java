package com.elysiaptr.wisdomslipsserver.filter;

import com.alibaba.fastjson2.JSON;
import com.elysiaptr.wisdomslipsserver.config.RequestConfig;
import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.dto.LoginUser;
import com.elysiaptr.wisdomslipsserver.exception.NoTokenException;
import com.elysiaptr.wisdomslipsserver.exception.WrongTokenException;
import com.elysiaptr.wisdomslipsserver.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * jwt权限校验过滤器
 *
 * @author ElysiaPtr
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RequestConfig requestConfig;

    /**
     * jwt过滤链
     *
     * @param request     请求
     * @param response    响应
     * @param filterChain 过滤链
     * @throws ServletException Servlet异常
     * @throws IOException      输入输出异常
     */
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 拿到访问的url
        String url = request.getRequestURI();
        log.debug("url: {}", url);

        // 放行登录api和开放api
        if (url.startsWith(requestConfig.getOpenApiHeader()) || url.startsWith(requestConfig.getLoginApiHeader())) {
            filterChain.doFilter(request, response);
            return;
        }

        // 判断请求头中"Authorization"是否为空
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            log.warn("the request for {}, token is empty", url);
            throw new NoTokenException(ErrorConstant.TOKEN_IS_EMPTY);
        }

        String loginUserStr = null;
        LoginUser loginUser = null;

        // 判断请求头中"Authorization"字段是否正确
        try {
            Claims claims = jwtUtil.parseJWT(token);
            loginUserStr = claims.getSubject();
            loginUser = JSON.parseObject(loginUserStr, LoginUser.class);
        } catch (Exception e) {
            log.warn("the request for {}, token is wrong", url);
            throw new WrongTokenException(ErrorConstant.TOKEN_IS_WRONG);
        }

        // 将当前token信息保存到Security上下文中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 放行
        filterChain.doFilter(request, response);
    }
}
