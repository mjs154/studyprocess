package com.mjs.licensing.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @ClassName TestConfigValue
 * @Author Administrator
 * @Data 2018/9/1 11:16
 * @Version 1.0
 */
//@RestController
public class TestConfigValue {
    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
}
