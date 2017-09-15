package com.cykj.controller;

import com.cykj.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Wjhsmart on 2017/7/21.
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, I'm first Application";
    }

    @RequestMapping("/helloJsp")
    public ModelAndView helloJsp() {
        ModelAndView mav = new ModelAndView("hello");
        User user = new User();
        user.setId(1);
        user.setName("危锦辉");
        user.setCreateTime(new Date());
        mav.addObject("user", user);
        mav.addObject("name", user.getName());
        return mav;
    }
}
