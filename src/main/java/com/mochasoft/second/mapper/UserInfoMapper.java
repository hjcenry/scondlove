package com.mochasoft.second.mapper;

import org.apache.ibatis.annotations.Param;

import com.mochasoft.second.model.UserInfo;
import com.mochasoft.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface UserInfoMapper {

	UserInfo getUserInfoByUserNameAndStatus(@Param("userName") String userName, @Param("marrytype") Integer marrytype);

	void saveUserInfo(UserInfo userInfo);

	void updateUserInfo(UserInfo userInfo);
}
