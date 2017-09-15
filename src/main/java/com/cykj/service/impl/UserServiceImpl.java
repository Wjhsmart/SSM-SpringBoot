package com.cykj.service.impl;

import com.cykj.bean.User;
import com.cykj.repository.UserRepository;
import com.cykj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Wjhsmart on 2017/7/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询数据库所有用户信息
     * @return
     */
    @Override
    public List<User> queryAll() {
        return userRepository.queryAll();
    }

    /**
     * 根据id查询数据库中用户的信息
     * @param id
     * @return
     */
    @Override
    public User queryById(int id) {
        return userRepository.queryById(id);
    }

    /**
     * 分页查询数据库用户信息
     * @return
     */
    @Override
    public List<User> queryByPager() {
        return userRepository.queryByPager();
    }

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    @Override
    public User queryByName(String name) {
        return userRepository.queryByName(name);
    }

    /**
     * 往数据库里添加一个用户
     * 需要开启事务
     * @param user
     * @return
     */
    @Transactional
    @Override
    public int insertUser(User user) {
        return userRepository.insertUser(user);
    }

    /**
     * 根据id更新用户的信息
     * @param user
     * @return
     */
    @Transactional
    @Override
    public int updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
