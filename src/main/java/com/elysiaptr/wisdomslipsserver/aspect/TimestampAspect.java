package com.elysiaptr.wisdomslipsserver.aspect;

import com.elysiaptr.wisdomslipsserver.annotation.AutoTimestamp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 插入时间切面类
 *
 * @author ElysiaPtr
 */
@Aspect
@Component
public class TimestampAspect {

    /**
     * 在insert方法的时候插入
     *
     * @param joinPoint 切点
     * @param entity    实例
     * @throws IllegalAccessException 非法输入错误
     */
    @Before("execution(* com.elysiaptr.wisdomslipsserver.mapper.*.insert(..)) && args(entity)")
    public void beforeInsert(JoinPoint joinPoint, Object entity) throws IllegalAccessException {
        if (entity.getClass().isAnnotationPresent(AutoTimestamp.class)) {
            setField(entity, "createTime", LocalDateTime.now());
            setField(entity, "updateTime", LocalDateTime.now());
        }
    }

    /**
     * 在update方法的时候插入
     *
     * @param joinPoint 切点
     * @param entity    实例
     * @throws IllegalAccessException 非法输入错误
     */
    @Before("execution(* com.elysiaptr.wisdomslipsserver.mapper.*.updateById(..)) && args(entity)")
    public void beforeUpdate(JoinPoint joinPoint, Object entity) throws IllegalAccessException {
        if (entity.getClass().isAnnotationPresent(AutoTimestamp.class)) {
            setField(entity, "updateTime", LocalDateTime.now());
        }
    }

    /**
     * 在delete方法的时候插入
     *
     * @param joinPoint 切点
     * @param entity    实例
     * @throws IllegalAccessException 非法输入错误
     */
    @Before("execution(* com.elysiaptr.wisdomslipsserver.mapper.*.deleteById(..)) && args(entity)")
    public void beforeDelete(JoinPoint joinPoint, Object entity) throws IllegalAccessException {
        if (entity.getClass().isAnnotationPresent(AutoTimestamp.class)) {
            setField(entity, "deleteTime", LocalDateTime.now());
        }
    }

    /**
     * 在批量insert方法的时候插入
     *
     * @param joinPoint 切点
     * @param entities  实例
     * @throws IllegalAccessException 非法输入错误
     */
    @Before("execution(* com.elysiaptr.wisdomslipsserver.mapper.*.batchInsert(..)) && args(entities)")
    public void beforeBatchInsert(JoinPoint joinPoint, List<?> entities) throws IllegalAccessException {
        for (Object entity : entities) {
            if (entity.getClass().isAnnotationPresent(AutoTimestamp.class)) {
                setField(entity, "createTime", LocalDateTime.now());
                setField(entity, "updateTime", LocalDateTime.now());
            }
        }
    }

    /**
     * 在批量update方法的时候插入
     *
     * @param joinPoint 切点
     * @param entities  实例
     * @throws IllegalAccessException 非法输入错误
     */
    @Before("execution(* com.elysiaptr.wisdomslipsserver.mapper.*.batchUpdate(..)) && args(entities)")
    public void beforeBatchUpdate(JoinPoint joinPoint, List<?> entities) throws IllegalAccessException {
        for (Object entity : entities) {
            if (entity.getClass().isAnnotationPresent(AutoTimestamp.class)) {
                setField(entity, "updateTime", LocalDateTime.now());
            }
        }
    }

    /**
     * 在批量delete方法的时候插入
     *
     * @param joinPoint 切点
     * @param entities  实例
     * @throws IllegalAccessException 非法输入错误
     */
    @Before("execution(* com.elysiaptr.wisdomslipsserver.mapper.*.batchDelete(..)) && args(entities)")
    public void beforeBatchDelete(JoinPoint joinPoint, List<?> entities) throws IllegalAccessException {
        for (Object entity : entities) {
            if (entity.getClass().isAnnotationPresent(AutoTimestamp.class)) {
                setField(entity, "deleteTime", LocalDateTime.now());
            }
        }
    }

    /**
     * 设置域名
     *
     * @param entity    实体
     * @param fieldName 域名
     * @param value     值
     * @throws IllegalAccessException 非法输入错误
     */
    private void setField(Object entity, String fieldName, LocalDateTime value) throws IllegalAccessException {
        Field field;
        try {
            field = entity.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return; // 如果字段不存在，则跳过
        }
        field.setAccessible(true);
        field.set(entity, value);
    }

}
