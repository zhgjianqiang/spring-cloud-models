package com.fuyun.configmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
//配置中心
@EnableConfigServer
//动态刷新
@RefreshScope
public class ConfigmodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigmodelApplication.class, args);
    }

}

