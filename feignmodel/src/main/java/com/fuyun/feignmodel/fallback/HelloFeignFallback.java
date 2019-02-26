package com.fuyun.feignmodel.fallback;

import com.fuyun.feignmodel.client.HelloFeignClient;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * HelloFeignFallback
 *
 * @author Zhu Qiang
 */
@Component
public class HelloFeignFallback implements FallbackFactory<HelloFeignClient> {

    @Override
    public HelloFeignClient create(Throwable cause) {
        return new HelloFeignClient() {
            @Override
            public String getHello() {
                return "hello fallback; reason:" + cause.getMessage();
            }

            @Override
            public String getError() {
                return "feign error fallback; reason:" + cause.getMessage();
            }

        };
    }
}
