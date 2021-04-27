package com.mybatis.demo.service.impl;

import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.model.User;
import com.mybatis.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description：
 * @Author: 小强
 * @Date: 2021/3/17 0017
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public int updateById(String password,int id) {
        return userMapper.updateById(password,id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }
}
