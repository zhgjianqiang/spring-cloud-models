package com.fuyun.hellodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Hellodemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hellodemo2Application.class, args);
    }

    @GetMapping(value = "hello")
    public String getHello() {
        return "helloworld2";
    }

    @GetMapping(value = "error")
    public String getError() {
        return "error2";
    }
}

