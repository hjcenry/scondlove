package com.mochasoft.second.model;

import java.io.Serializable;
import java.util.Date;

public class BazaarClassify implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2976944567385468237L;

	private String classifyId;// 分类id
	private String classifyName;// 分类名称
	private int realtype;// 分类业务类型（1.二手市场）
	private String createUser;// 分类创建人id
	private Date createTime;// 分类创建时间
	private String updateUser;// 分类修改人id
	private Date updateTime;// 分类修改时间
	private int status;// 分类使用状态

	public String getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
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

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getRealtype() {
		return realtype;
	}

	public void setRealtype(int realtype) {
		this.realtype = realtype;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
