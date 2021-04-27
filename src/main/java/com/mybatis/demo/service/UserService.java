package com.mybatis.demo.service;

import com.mybatis.demo.model.User;
import java.util.List;

/**
 * @Description：
 * @Author: 小强
 * @Date: 2021/3/17 0017
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
public interface UserService {
    List<User> findAll();
    User findById(int id);
    User findByName(String name);
    int updateById(String password,int id);
    int insertUser(User user);
    int deleteById(int id);
}
