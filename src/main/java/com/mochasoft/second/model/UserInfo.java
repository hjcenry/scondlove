package com.mochasoft.second.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2976944567385468237L;

	private String userId;//用户id
	private String userName;// 用户名
	private String nickname;
	private String userImage;// 用户头像
	private Integer userSex;// 用户性别（1.男，2.女，3.保密）
	private String telphone;// 联系方式
	private Date createTime;// 用户创建时间
	private Integer status;// 用户状态
	private Date birthday;//生日
	private String birthdays;//生日
	
	private Integer marrystatus;//婚姻状态0未婚1离婚2丧偶
	private Integer height;//身高
	private String education;//学历
	private String monthly;//月薪
	private String province;//省
	private String city;//区域
	private Integer marrytype;//情缘信息状态
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBirthdays() {
		return birthdays;
	}
	public void setBirthdays(String birthdays) {
		this.birthdays = birthdays;
	}
	public Integer getMarrystatus() {
		return marrystatus;
	}
	public void setMarrystatus(Integer marrystatus) {
		this.marrystatus = marrystatus;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMonthly() {
		return monthly;
	}
	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getMarrytype() {
		return marrytype;
	}
	public void setMarrytype(Integer marrytype) {
		this.marrytype = marrytype;
	}
	

}
