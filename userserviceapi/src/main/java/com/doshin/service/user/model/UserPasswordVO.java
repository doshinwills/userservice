package com.doshin.service.user.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "password")
public class UserPasswordVO {

	private Integer passwordId;
	private String password;
	private Date createdOn;
	private Date updatedOn;

	public UserPasswordVO() {
		super();
	}

	public UserPasswordVO(Integer passwordId, String password, Date createdOn, Date updatedOn) {
		super();
		this.passwordId = passwordId;
		this.password = password;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Integer getPasswordId() {
		return passwordId;
	}

	public void setPasswordId(Integer passwordId) {
		this.passwordId = passwordId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "UserPasswordVO [passwordId=" + passwordId + ", password=" + password + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}

}
