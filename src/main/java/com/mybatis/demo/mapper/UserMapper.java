package com.mybatis.demo.mapper;

import com.mybatis.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description：
 * @Author: 小强
 * @Date: 2021/3/17 0017
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Mapper
public interface UserMapper {
    List<User> findAll();

    User findByName(String name);

    User findById(int id);

    int updateById(@Param("password") String password, @Param("id") int id);

    int insertUser(User user);

    int deleteById(int id);
}
