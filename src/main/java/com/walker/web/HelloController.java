package com.walker.web;

import com.walker.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String Hello() {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        log.trace("测试{}，日志级别{}，输出{}", "demo1", "trace", "trace level log");

        log.debug("测试{}，日志级别{}，输出{}", "demo1", "debug", "debug level log");

        log.info("测试{}，日志级别{}，输出{}", "demo1", "info", "info level log");

        log.warn("测试{}，日志级别{}，输出{}", "demo1", "warn", "warn level log");

        log.error("测试{}，日志级别{}，输出{}", "demo1", "error", "error level log");
        return "Hello Spring Boot";
    }

    @RequestMapping("/map")
    public String Map() {
        try {
            String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> bodyMap = objectMapper.readValue(carJson, Map.class);

            log.info("测试 brand {}", bodyMap.get("brand"));
            log.info("bodyMap {}", bodyMap);

            return bodyMap.toString();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "Hello";
    }

    @RequestMapping("/user")
    public User getUser() {
        User user = new User();
        user.setUsername("jacook");
        user.setAge(18);
        return user;
    }

}
