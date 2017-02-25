package com.doshin.service.user.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user", schema="public")
public class UserDO {

	public List<GroupDO> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupDO> groupList) {
		this.groupList = groupList;
	}

	@Id
	@Column(name = "userid")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer userId;

	@Column(name = "name")
	private String name;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "updatedon")
	private Date updatedOn;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passwordid")
	UserPasswordDO userPassword;
	
	@OneToMany
	@JoinTable(name="usergroup", 
		joinColumns=@JoinColumn(name="userid"),
		inverseJoinColumns=@JoinColumn(name="groupid"))
	List<GroupDO> groupList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public UserPasswordDO getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(UserPasswordDO userPassword) {
		this.userPassword = userPassword;
	}

}
