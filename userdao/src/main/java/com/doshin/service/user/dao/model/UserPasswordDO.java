package com.doshin.service.user.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userpassword")
public class UserPasswordDO {

	@Id
	@Column(name = "passwordid")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer passwordId;

	@Column(name = "password")
	private String password;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "updatedon")
	private Date updatedOn;

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

}
