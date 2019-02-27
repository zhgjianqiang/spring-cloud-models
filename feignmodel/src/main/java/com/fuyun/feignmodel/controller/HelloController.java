package com.fuyun.feignmodel.controller;

import com.fuyun.feignmodel.client.HelloFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HelloController
 *
 * @author Zhu Qiang
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${name}")
    String name;

    @Resource
    HelloFeignClient helloFeignClient;

    @GetMapping("/f-hello")
    public String getHello() {
        return helloFeignClient.getHello() + ", name=" + name;
    }

    @GetMapping("/f-error")
    @HystrixCommand(fallbackMethod = "fallbackError")
    public String getError() {
        return helloFeignClient.getError();
    }

    public String fallbackError() {
        return "hystrix fallback error";
    }
}
