package com.elysiaptr.wisdomslipsserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置信息
 *
 * @author ElysiaPtr
 */
@ConfigurationProperties(prefix = "config.request")
@Component
@Data
public class RequestConfig {
    /**
     * 需要鉴权的api
     */
    private String authenticationApi;

    /**
     * 开放api
     */
    private String openApi;

    /**
     * 登陆api
     */
    private String loginApi;

    /**
     * 开放api开头
     */
    private String openApiHeader;

    /**
     * 登陆api开头
     */
    private String loginApiHeader;

    /**
     * 需要鉴权的api开头
     */
    private String authenticationApiHeader;
}
