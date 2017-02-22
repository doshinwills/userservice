package com.doshin.service.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserVO {
	private Integer userId;

	private String name;

	private String firstName;

	private String lastName;

	private Date createdOn;

	private Date updatedOn;

	UserPasswordVO userPassword = new UserPasswordVO();

	List<GroupVO> groupList = new ArrayList<GroupVO>();

	public UserVO() {
		super();
	}

	public UserVO(Integer userId, String name, String firstName, String lastName, Date createdOn, Date updatedOn,
			UserPasswordVO userPassword, List<GroupVO> groupList) {
		super();
		this.userId = userId;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.userPassword = userPassword;
		this.groupList = groupList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public UserPasswordVO getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(UserPasswordVO userPassword) {
		this.userPassword = userPassword;
	}

	public List<GroupVO> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupVO> groupList) {
		this.groupList = groupList;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", userPassword=" + userPassword
				+ ", groupList=" + groupList + "]";
	}

}