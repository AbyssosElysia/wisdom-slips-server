package com.elysiaptr.wisdomslipsserver;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@MapperScan("com.elysiaptr.wisdomslipsserver.mapper")
public class WisdomSlipsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WisdomSlipsServerApplication.class, args);
    }

}
