package com.mochasoft.second.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mochasoft.second.mapper.UserInfoMapper;
import com.mochasoft.second.model.UserInfo;

@Component
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfo getUserInfoByUserNameAndStatus(String userName, Integer status) {
		return userInfoMapper.getUserInfoByUserNameAndStatus(userName, status);
	}

	public void saveUserInfo(UserInfo userInfo){
		userInfoMapper.saveUserInfo(userInfo);
	}

	public void updateUserInfo(UserInfo userInfo) {
		userInfoMapper.updateUserInfo(userInfo);
	}
}
