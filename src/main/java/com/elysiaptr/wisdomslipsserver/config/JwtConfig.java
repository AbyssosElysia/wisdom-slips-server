package com.elysiaptr.wisdomslipsserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置信息
 *
 * @author ElysiaPtr
 */
@ConfigurationProperties(prefix = "config.jwt")
@Component
@Data
public class JwtConfig {
    /**
     * 存在时间，单位：毫秒
     */
    private Long ttl;

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 发布者
     */
    private String issuer;
}
