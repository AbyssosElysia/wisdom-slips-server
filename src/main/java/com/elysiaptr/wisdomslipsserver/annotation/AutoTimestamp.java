package com.elysiaptr.wisdomslipsserver.annotation;

import java.lang.annotation.*;

/**
 * 注解，用于实体类，自动插入
 *
 * @author ELysiaPtr
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoTimestamp {
}
