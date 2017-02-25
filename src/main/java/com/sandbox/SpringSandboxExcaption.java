package com.sandbox;

import com.google.gson.Gson;
import com.sandbox.VO.Sandbox;
import com.sandbox.utils.ResponseUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by mike on 2017/2/25.
 */
@RestControllerAdvice
@EnableWebMvc
public class SpringSandboxExcaption {
    private static final Logger logger = LoggerFactory.getLogger(SpringSandboxExcaption.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    @ResponseBody
    public Sandbox globalException(HttpServletRequest request, HttpServletResponse response, Exception exception){
        Gson gson = new Gson();
        logger.error(gson.toJson(exception));
        Sandbox sandbox = new Sandbox();
        ModelMap modelMap = new ModelMap();
        // TODO 需要区分 404 之类的错误
        sandbox.setMsg(ResponseUtils.ERROR_MSG);
        sandbox.setStatus(ResponseUtils.ERROR_CODE);
        modelMap.put("url", request.getRequestURL());
        modelMap.put("error", exception.getMessage());
        modelMap.put("cause", exception.getCause());
        sandbox.setResult(modelMap);
        return sandbox;
    }
}
