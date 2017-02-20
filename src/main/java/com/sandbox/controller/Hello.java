package com.sandbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mike on 2017/2/19.
 */
@RestController
@RequestMapping("/hello")
public class Hello {

    private static final Logger logger =  LoggerFactory.getLogger(Hello.class);

    @RequestMapping("/")
    @ResponseBody
    public Map<String, Object> sayHi(){
        logger.debug("logger test in hello.class");
        Map<String, Object> result = new HashMap<>();
        result.put("a", 11);
        result.put("b", "hello");
        return result;
    }

}
