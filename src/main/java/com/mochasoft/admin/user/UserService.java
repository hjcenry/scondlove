package com.mochasoft.admin.user; 

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUP(String username,String password){
		return userMapper.getUserByUP(username, password);
	}
}
