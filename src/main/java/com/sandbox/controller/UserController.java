package com.sandbox.controller;

import com.sandbox.VO.Sandbox;
import com.sandbox.VO.UserVO;
import com.sandbox.service.UserService;
import com.sandbox.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mike on 2017/2/21.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public Sandbox listAll(Sandbox sandbox, ModelMap modelMap){
        List<UserVO> users = userService.findAll();
        sandbox.setMsg(ResponseUtils.SUCCESS_MSG);
        sandbox.setStatus(ResponseUtils.SUCCESS_CODE);
        modelMap.put("data", users);
        modelMap.put("total", users.size());
        modelMap.put("meta", "meta content");
        logger.debug("----------------");
        logger.debug(String.valueOf(users.size()));
        logger.debug("----------------");
//        sandbox.setResult("content", new Object());
        return sandbox;
    }
}
