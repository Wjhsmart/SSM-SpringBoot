package com.cykj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Wjhsmart on 2017/7/24.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String defaultIndex() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:/";
    }
}
