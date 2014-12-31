package com.mochasoft.second.model;

import java.io.Serializable;
import java.util.Date;

public class DealMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7950909713414469873L;
	

	private String dealId;// 活动id
	private String dealTitle;// 活动名称
	private String dealDesc;// 活动描述
	private String dealImage;// 活动图片
	private String dealHope;// 活动时间
	private int dealType;// 活动类型（1.发动态，2发邀请）
	private String classifyId;// 分类id
	private int dealStatus;// 活动状态（0.关闭，1.打开，2.完成）
	private String createUser;// 活动创建人id
	private Date createTime;// 活动创建时间
	private Date updateTime;// 活动修改时间
	private int status;//活动编辑状态（0.草稿，1.发布）

	private String userName;//用户名
	private String nickname;
	private String userImage;//用户头像
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getDealTitle() {
		return dealTitle;
	}
	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}
	public String getDealDesc() {
		return dealDesc;
	}
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}
	public String getDealImage() {
		return dealImage;
	}
	public void setDealImage(String dealImage) {
		this.dealImage = dealImage;
	}
	
	
	public String getDealHope() {
		return dealHope;
	}
	public void setDealHope(String dealHope) {
		this.dealHope = dealHope;
	}
	public int getDealType() {
		return dealType;
	}
	public void setDealType(int dealType) {
		this.dealType = dealType;
	}
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public int getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(int dealStatus) {
		this.dealStatus = dealStatus;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	
	

}
