package com.fuyun.gatewaydemo.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Component
@ConfigurationProperties("request-modify")
@Data
public class RequestModifyProperties {

    private List<RequestModify> modifyList = new ArrayList<>();

    private Map<String, Map<String, String>> parametersMap = new HashMap<>();

    @Data
    public static class RequestModify {
        private String routeId;
        private String httpMethod;
        private String paths;
        private Map<String, Object> addValue = new HashMap<>();

    }

}
