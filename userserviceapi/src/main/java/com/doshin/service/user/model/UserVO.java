package com.doshin.service.user.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserVO {
	private int id;

	private String usertype;

	private String firstname;

	private String lastname;

	private String address;

	private String username;

	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userType=" + usertype + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", username=" + username + ", password=" + password + "]";
	}
	
	

}