package com.sandbox.controller;

import com.sandbox.VO.ArticleVO;
import com.sandbox.VO.Sandbox;
import com.sandbox.service.ArticleService;
import com.sandbox.utils.ResponseUtils;
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
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(name = "/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Sandbox listAll(ModelMap modelMap){
        List<ArticleVO> articleVOs = articleService.findAll();
        Sandbox sandbox = new Sandbox();
        sandbox.setMsg(ResponseUtils.SUCCESS_MSG);
        sandbox.setStatus(ResponseUtils.SUCCESS_CODE);
        modelMap.put("data", articleVOs);
        modelMap.put("total", articleVOs.size());
        modelMap.put("meta", "meta content 元数据");
        sandbox.setResult(modelMap);
        return sandbox;
    }
    
}
