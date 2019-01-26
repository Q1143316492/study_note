package com.shiyanlou.controller;

import com.shiyanlou.model.User;
import com.shiyanlou.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理用户请求 Controller
 **/
@Controller
public class UserController {

    /**
     * 自动注入 UserService
     **/
    @Autowired
    private UserService userService;

    // 登录
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        User loginUser = userService.login(user);

        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            return "redirect:alluser";
        } else {
            session.setAttribute("message", "username or password is wrong!");
            return "redirect:loginform.jsp";
        }
    }

    // 退出
    @RequestMapping(value = "/loginout")
    public String loginout(HttpSession session) {
        session.invalidate();
        return "redirect:loginform.jsp";
    }

    // 查询所有用户
    @RequestMapping("/alluser")
    public String selectAllUser(HttpServletRequest request) {
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        return "userlist";
    }

    // 跳转至新增用户页面
    @RequestMapping("/toadduser")
    public String toAddUserPage() {
        return "adduser";
    }

    // 新增用户
    @RequestMapping("/adduser")
    public String addUser(User user, HttpServletRequest request) {
        userService.addUser(user);
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        return "userlist";
    }

    // 跳转至更新用户页面
    @RequestMapping("/toupdateuser")
    public String toUpdateUser(@Param("id") Integer id,
                               HttpServletRequest request, Model model) {
        model.addAttribute("user_id", id);
        return "updateuser";
    }

    // 更新用户
    @RequestMapping("/updateuser")
    public String updateUser(User user, HttpServletRequest request) {
        userService.updateUser(user);
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        return "userlist";
    }

    // 删除用户
    @RequestMapping("/deleteuser")
    public String deleteUser(@Param("id") Integer id, HttpServletRequest request) {
        userService.deleteUser(id);
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        return "userlist";
    }
}
