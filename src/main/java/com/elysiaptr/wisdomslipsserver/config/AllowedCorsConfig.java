package com.elysiaptr.wisdomslipsserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 跨域配置信息
 *
 * @author ElysiaPtr
 */
@ConfigurationProperties(prefix = "config.cors")
@Component
@Data
public class AllowedCorsConfig {
    /**
     * 允许的原地址
     */
    private List<String> allowedUrls;

    /**
     * 允许的方法
     */
    private List<String> allowedMethods;

    /**
     * 允许的请求头
     */
    private List<String> allowedHeaders;

    /**
     * 允许请求的地址
     */
    private String allowedPath;
}
