package com.mochasoft.admin.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mochasoft.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface UserMapper {
	
	User getUserByUP(@Param("username")String username,@Param("password")String password);
}