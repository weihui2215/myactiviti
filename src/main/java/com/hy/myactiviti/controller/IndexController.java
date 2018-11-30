package com.hy.myactiviti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: myactiviti
 * @description: 测试
 * @author: hliu
 * @create: 2018-11-30 10:00
 **/

@RestController
@RequestMapping(value = "/index")
public class IndexController {


    @RequestMapping(value = "")
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
