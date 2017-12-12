package com.example.shop.mapper;

import com.example.shop.common.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    User selectByUsername(String userName);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User login(@Param("userName") String userName, @Param("password") String password);
}