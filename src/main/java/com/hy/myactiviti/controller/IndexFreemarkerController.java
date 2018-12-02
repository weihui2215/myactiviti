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
@RequestMapping(value = "/")
public class IndexFreemarkerController {

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}
