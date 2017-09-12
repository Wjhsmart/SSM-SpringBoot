package com.cykj.service;

import com.cykj.bean.User;
import com.cykj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Wjhsmart on 2017/7/27.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询数据库所有用户信息
     * @return
     */
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    /**
     * 根据id查询数据库中用户的信息
     * @param id
     * @return
     */
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    /**
     * 分页查询数据库用户信息
     * @return
     */
    public List<User> queryByPager() {
        return userMapper.queryByPager();
    }

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }

    /**
     * 往数据库里添加一个用户
     * 需要开启事务
     * @param user
     * @return
     */
    @Transactional
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 根据id更新用户的信息
     * @param user
     * @return
     */
    @Transactional
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
