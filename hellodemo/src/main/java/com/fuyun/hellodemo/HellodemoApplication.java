package com.fuyun.hellodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Random;

@SpringBootApplication
@RestController
public class HellodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellodemoApplication.class, args);
    }

    @GetMapping(value = "hello")
    public String getHello() {
        return "helloworld1";
    }

    @GetMapping(value = "error")
    public String getError() {
        int rondom = new Random().nextInt(10);
        if (rondom < 10) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");
        } else {
            return "error1";
        }
    }

}

