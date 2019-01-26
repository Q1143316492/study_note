package com.shiyanlou.service;

import com.shiyanlou.model.User;

import java.util.List;

public interface UserService {

    /**
     * 用户登录
     *
     * @param user
     * @return 登录成功返回 User 对象，失败返回 null
     **/
    User login(User user);

    /**
     * 查询所有用户
     *
     * @return 查询到的所有 User 对象的 list
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
     * @param id（用户 id）
     **/
    void deleteUser(Integer id);
}
