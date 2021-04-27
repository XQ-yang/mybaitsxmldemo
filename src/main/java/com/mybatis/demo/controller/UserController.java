package com.mybatis.demo.controller;

import com.mybatis.demo.model.User;
import com.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description：
 * @Author: 小强
 * @Date: 2021/3/17 0017
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*
     * 查询所有
     * */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        List<User> userList = userService.findAll();
        return userList;
    }

    /**
     * 根据id查询
     * */
    @RequestMapping("/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") int id) {
        User user = userService.findById(id);
        return user;
    }

    /**
     * 根据id更新
     * */
    @RequestMapping("/updateById/{password}/{id}")
    public String updateById(@PathVariable("password") String password, @PathVariable("id") int id) {
        int row = userService.updateById(password, id);
        if (row > 0) {
            return "success";
        }
        return "fail";
    }

    /**
     * 插入用户
     * */
    @RequestMapping("/insertUser")
    public String updateById(User user) {
        int row = userService.insertUser(user);
        if (row > 0) {
            return "success";
        }
        return "fail";
    }

    /**
     * 删除用户
     * */
    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        int row = userService.deleteById(id);
        if (row > 0) {
            return "success";
        }
        return "fail";
    }

    /**
     * 登录
     * */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录成功
     * */
    @RequestMapping("/loginSuccess")
    public String loginSuccess(Model model, User user) {
        User user1 = userService.findByName(user.getName());
        if (user1 != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                System.out.println(user1.toString());
                return "success";
            } else {
                model.addAttribute("data", "密码错误！！");
                return "login";
            }
        } else {
            model.addAttribute("data", "用户名错误！！");
            return "login";
        }
    }

    /**
     * 注册
     * */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 注册成功
     * */
    @RequestMapping("/toRegisterSuccess")
    public String toRegisterSuccess(Model model, User user, HttpServletRequest request) {
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)) {
            //添加一条记录到数据库中
            int add = userService.insertUser(user);
            System.out.println("插入数据成功");
            model.addAttribute("data", "注册成功，请登录");
            return "login";
        } else {
            model.addAttribute("data", "确认密码与原密码不一样");
            return "register";
        }
    }
}
