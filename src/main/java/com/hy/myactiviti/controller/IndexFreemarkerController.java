package com.hy.myactiviti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: myactiviti
 * @description: ftl controller
 * @author: hliu
 * @create: 2018-11-30 13:33
 **/

@Controller
@RequestMapping(value = "/index")
public class IndexFreemarkerController {

    @RequestMapping(value = "/login")
    public ModelAndView index(ModelAndView modelAndView) {

        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        modelAndView.setViewName("index");

        List<String> userList=new ArrayList<String>();
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");

        modelAndView.addObject("ctx",path);
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping(value = "/login1")
    public ModelAndView index1() {
        ModelAndView modelAndView = new ModelAndView("/main/index");

        List<String> userList=new ArrayList<String>();
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");

        modelAndView.addObject("userList", userList);
        return modelAndView;
    }
}
