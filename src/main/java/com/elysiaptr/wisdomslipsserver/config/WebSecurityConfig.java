package com.elysiaptr.wisdomslipsserver.config;

import com.elysiaptr.wisdomslipsserver.filter.JwtAuthenticationTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * SpringSecurity配置信息
 *
 * @author ElysiaPtr
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private AllowedCorsConfig allowedCorsConfig;

    @Autowired
    private RequestConfig requestConfig;

    /**
     * 将密码加密使用的编解码器加入bean
     *
     * @return 密码加密使用的编解码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        log.debug("Creating password encoder");
        return new BCryptPasswordEncoder();
    }

    /**
     * 将鉴权处理器加入bean
     *
     * @param configuration 鉴权配置
     * @return 鉴权处理器
     * @throws Exception 异常
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        log.debug("Creating authentication manager");
        return configuration.getAuthenticationManager();
    }

    /**
     * 将跨域设置加入bean
     *
     * @return 返回跨域设置
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        log.debug("Creating CorsConfigurationSource");
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(allowedCorsConfig.getAllowedUrls()); // 允许的域
        configuration.setAllowedMethods(allowedCorsConfig.getAllowedMethods());  // 允许的方法
        configuration.setAllowedHeaders(allowedCorsConfig.getAllowedHeaders());  // 允许的请求头
        configuration.setAllowCredentials(true);  // 允许客户端发送凭证信息

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(allowedCorsConfig.getAllowedPath(), configuration);  // 允许访问的地址

        return source;
    }

    /**
     * 将需鉴权api鉴权拦截器加入拦截链
     *
     * @param http http请求
     * @return 需鉴权api拦截器
     * @throws Exception 异常
     */
    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        log.debug("Creating ApiSecurityFilterChain");
        commonHttpSetting(http);
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 匹配相应则的请求
                .securityMatcher(requestConfig.getAuthenticationApi())
                .authorizeHttpRequests(auth -> auth
                        // 除了登陆不拦截，其他均拦截
                        // TODO 改为拦截
//                        .requestMatchers(requestConfig.getLoginApi()).permitAll()
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated());

        // 定义拦截器添加位置
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * 将开放api鉴权拦截器加入拦截链
     *
     * @param http http请求
     * @return 开放api拦截器
     * @throws Exception 异常
     */
    @Bean
    public SecurityFilterChain openApiFilterChain(HttpSecurity http) throws Exception {
        log.debug("Creating OpenApiSecurityFilterChain");
        commonHttpSetting(http);
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .securityMatcher("/open_api/**")
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll());
        return http.build();
    }

    /**
     * 禁用不必要的默认filter，处理异常响应内容
     *
     * @param http http请求
     * @throws Exception 异常
     */
    private void commonHttpSetting(HttpSecurity http) throws Exception {
        log.debug("Creating CommonHttpSetting");
        // 禁用SpringSecurity默认filter。这些filter都是非前后端分离项目的产物，用不上.
        // yml配置文件将日志设置DEBUG模式，就能看到加载了哪些filter
        // logging:
        //    level:
        //       org.springframework.security: DEBUG
        // 表单登录/登出、session管理、csrf防护等默认配置，如果不disable。会默认创建默认filter
        http.formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                // requestCache用于重定向，前后端分析项目无需重定向，requestCache也用不上
                .requestCache(cache -> cache
                        .requestCache(new NullRequestCache())
                )
                // 无需给用户一个匿名身份
                .anonymous(AbstractHttpConfigurer::disable);
    }
}
