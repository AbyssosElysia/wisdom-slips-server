package com.elysiaptr.wisdomslipsserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger文档配置信息
 *
 * @author ElysiaPtr
 */
@Slf4j
@Configuration
public class WebMvcConfig {

    /**
     * 配置文档基本信息
     * @return 新建文档类实例
     */
    @Bean
    public Docket docket() {
        log.info("begin to build docket");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("简书服务文档")
                .version("1.0")
                .description("简书服务测试文档")
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.elysiaptr.wisdomslipsserver.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * 设置静态资源映射
     *
     * @param registry 静态资源处理规则
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("begin to add resource handlers");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
