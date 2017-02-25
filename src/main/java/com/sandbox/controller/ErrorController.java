package com.sandbox.controller;

import com.google.gson.Gson;
import com.sandbox.VO.Sandbox;
import com.sandbox.utils.ResponseUtils;
import java.lang.String;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mike on 2017/2/25.
 */
@RestController
public class ErrorController {

    @RequestMapping("/404")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Sandbox showServer404(HttpServletRequest request) {
        Sandbox sandbox = new Sandbox();
        sandbox.setMsg(String.format(ResponseUtils.NOT_FOUND_MSG, request.getAttribute("javax.servlet.forward.request_uri")));
        sandbox.setStatus(ResponseUtils.NOT_FOUND_CODE);
        return sandbox;
    }

    @RequestMapping("/500")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Sandbox showServer500() {
        Sandbox sandbox = new Sandbox();
        sandbox.setMsg(ResponseUtils.ERROR_MSG);
        sandbox.setStatus(ResponseUtils.ERROR_CODE);
        return sandbox;
    }

    @RequestMapping("/502")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    public Sandbox showServer502(HttpServletRequest request) {
        Sandbox sandbox = new Sandbox();
        sandbox.setMsg(String.format(ResponseUtils.TIMEOUT_MSG, request.getAttribute("javax.servlet.forward.request_uri")));
        sandbox.setStatus(ResponseUtils.TIMEOUT_CODE);
        return sandbox;
    }
}
