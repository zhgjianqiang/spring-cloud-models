package com.fuyun.feignmodel.client;

import com.fuyun.feignmodel.fallback.HelloFeignFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloFeignClient
 *
 * @author Zhu Qiang
 */
@FeignClient(name = "hellodemo", fallbackFactory = HelloFeignFallback.class)
public interface HelloFeignClient {

    @GetMapping("hello")
    String getHello();

    @GetMapping("error")
    String getError();

}
