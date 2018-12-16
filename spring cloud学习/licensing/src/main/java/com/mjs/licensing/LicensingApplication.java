package com.mjs.licensing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 告诉spring boot框架，该类为引导类
 * 调用该类的main中 SpringApplication.run方法 启动spring boot服务
 *  服务核心初始化逻辑都在该类中
 */
@SpringBootApplication
public class LicensingApplication {

    public static void main(String[] args) {

        SpringApplication.run(LicensingApplication.class, args);
    }
}
