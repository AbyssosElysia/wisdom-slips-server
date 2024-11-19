package com.elysiaptr.wisdomslipsserver.util;

import com.elysiaptr.wisdomslipsserver.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * 用于获取jwt密钥的工具包
 *
 * @author ElysiaPtr
 */
@Component
@Slf4j
public class JwtUtil {

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 生成JWT密钥
     *
     * @param subject   主题
     * @param ttlMillis 生命周期
     * @return 生成的JWT密钥
     */
    public String generateJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    /**
     * 解析客户发送的JWT
     *
     * @param jwt 客户端发送的jwt
     * @return 密钥正确性声明
     */
    public Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * 获取uuid
     *
     * @return 去掉-的uuid
     */
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 读取自定义密钥，并进行Base64编码
     *
     * @return Base64编码的JWT密钥
     */
    private String getJwtKey() {
        return Base64.getEncoder().encodeToString(jwtConfig.getSecretKey().getBytes());
    }

    /**
     * 使用Base64编码的自定义密钥实例化密钥类
     *
     * @return 实例化密钥类
     */
    public SecretKey generalKey() {
        byte[] keyBytes = Base64.getDecoder().decode(getJwtKey());
        return new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
    }

    /**
     * 生成JWT的逻辑
     *
     * @param subject   主题
     * @param ttlMillis 生命周期
     * @param uuid      uuid
     * @return 已经设置好参数的JwtBuilder
     */
    private JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {

        // 选择签名算法为HS256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 获取使用自定义密钥串生成的密钥实例
        SecretKey secretKey = generalKey();

        // 获取当前时间戳
        long nowMillis = System.currentTimeMillis();

        // 获取当前时间
        Date now = new Date(nowMillis);

        // 如果没有写入生命周期，则导入预设生命周期
        if (ttlMillis == null) {
            ttlMillis = jwtConfig.getTtl();
        }

        // 计算过期时间
        long expMillis = nowMillis + ttlMillis;

        // 计算过期日期
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setSubject(subject)  // 设置主题
                .setIssuer("elysiaptr")  // 设置签发者
                .setId(uuid)  // 设置唯一编号
                .setIssuedAt(now)  // 设置签发日期
                .signWith(signatureAlgorithm, secretKey)  // 设置签名算法和密钥
                .setExpiration(exp);  // 设置过期日期
    }
}