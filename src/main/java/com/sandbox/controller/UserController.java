package com.sandbox.controller;

import com.sandbox.VO.Sandbox;
import com.sandbox.VO.UserVO;
import com.sandbox.domain.User;
import com.sandbox.service.UserService;
import com.sandbox.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(name = "/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Sandbox listAll(ModelMap modelMap){
//        userService.saveMany();
        List<UserVO> users = userService.findAll();
        Sandbox sandbox = new Sandbox();
        sandbox.setMsg(ResponseUtils.SUCCESS_MSG);
        sandbox.setStatus(ResponseUtils.SUCCESS_CODE);
        modelMap.put("data", users);
        modelMap.put("total", users.size());
        modelMap.put("meta", "meta content 元数据");
        sandbox.setResult(modelMap);
        return sandbox;
    }
}
