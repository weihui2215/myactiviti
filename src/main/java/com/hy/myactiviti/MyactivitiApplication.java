package com.hy.myactiviti;

import org.activiti.engine.RuntimeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootApplication
@MapperScan("com.hy.myactiviti.mapper")
@Configuration
public class MyactivitiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MyactivitiApplication.class, args);

        assertNotNull(ctx.getBean(RuntimeService.class));

        System.out.println("通过Spring Boot启动了Http Server，以下是Spring Boot扫描的Bean列表：");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            // System.out.println("found bean -> " + beanName);
        }
    }
}
