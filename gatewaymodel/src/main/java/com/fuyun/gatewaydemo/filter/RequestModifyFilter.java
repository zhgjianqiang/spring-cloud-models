package com.fuyun.gatewaydemo.filter;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@RefreshScope
@Slf4j
public class RequestModifyFilter implements GlobalFilter, Ordered {

    @Resource
    RequestModifyProperties requestModifyProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(requestModifyProperties.getParametersMap());
        System.out.println(requestModifyProperties.getModifyList());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE + 105;
    }
}
