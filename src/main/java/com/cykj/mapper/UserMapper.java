package com.cykj.mapper;

import com.cykj.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Wjhsmart on 2017/7/25.
 */
public interface UserMapper {

    /**
     * 查询数据库所有用户信息
     * @return
     */
    @Select("select * from t_user")
    public List<User> queryAll();

    /**
     * 根据id查询数据库中用户的信息
      * @param id
     * @return
     */
    @Select("select * from t_user where id = #{id}")
    public User queryById(int id);

    /**
     * 分页查询数据库用户信息
     * @return
     */
    @Select("select * from t_user")
    public List<User> queryByPager();

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    @Select("select * from t_user where name = #{name }")
    public User queryByName(String name);

    /**
     * 往数据库里添加一个用户
     * @param user
     * @return
     */
    @Insert("insert into t_user(name, createdTime) values(#{name}, #{createdTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insertUser(User user);

    /**
     * 根据id更新用户的信息
     * @param user
     * @return
     */
    @Update("update t_user set name = #{name}, createdTime = #{createdTime} where id = #{id}")
    public int updateUser(User user);
}
