package com.cykj.controller;

import com.cykj.bean.User;
import com.cykj.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Wjhsmart on 2017/7/24.
 */
@RestController
@RequestMapping("user")
public class UserController {

   @Autowired
    private UserService userService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("危锦辉");
        user.setCreatedTime(new Date());
        return user;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<User> all() {
        return userService.queryAll();
    }

    @RequestMapping("id/{id}")
    public User queryById(@Param("id") Integer id) {
        return userService.queryById(id);
    }

    @RequestMapping("save")
    public int saveUser() {
        User user = new User();
        user.setName("张三");
        user.setCreatedTime(new Date());
        return userService.insertUser(user);
    }

    @RequestMapping("update")
    public int updateUser(String name) {
        User user = userService.queryByName(name);
        user.setName("李四");
        user.setCreatedTime(new Date());
        return userService.updateUser(user);
    }

    @RequestMapping("page")
    public List<User> queryByPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return userService.queryByPager();
    }
}
