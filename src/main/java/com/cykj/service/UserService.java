package com.cykj.service;

import com.cykj.bean.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Wjhsmart on 2017/9/14.
 */
public interface UserService {

    /**
     * 查询数据库所有用户信息
     * @return
     */
    public List<User> queryAll();

    /**
     * 根据id查询数据库中用户的信息
     * @param id
     * @return
     */
    public User queryById(int id);

    /**
     * 分页查询数据库用户信息
     * @return
     */
    public List<User> queryByPager();

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    public User queryByName(String name);

    /**
     * 往数据库里添加一个用户
     * 需要开启事务
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 根据id更新用户的信息
     * @param user
     * @return
     */
    public int updateUser(User user);
}
