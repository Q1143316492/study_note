package com.shiyanlou.mapper;

import com.shiyanlou.model.User;

import java.util.List;

public interface UserMapper {

    /**
     * 用户登录查询
     *
     * @param user
     * @return User
     **/
    User selectLogin(User user);

    /**
     * 查询全部用户
     *
     * @return List<User>
     **/
    List<User> selectAllUser();

    /**
     * 新增用户
     *
     * @param user
     **/
    void addUser(User user);

    /**
     * 更新用户
     *
     * @param user
     **/
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     **/
    void deleteUser(Integer id);
}