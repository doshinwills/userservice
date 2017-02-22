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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "group")
public class GroupDO {

	@Id
	@Column(name = "groupid")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer groupId;

	@Column(name = "name")
	private String name;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "updatedon")
	private Date updatedOn;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "groupright", joinColumns = @JoinColumn(name = "groupid") , inverseJoinColumns = @JoinColumn(name = "rightid") )
	List<RightDO> rightList;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<RightDO> getRightList() {
		return rightList;
	}

	public void setRightList(List<RightDO> rightList) {
		this.rightList = rightList;
	}

}
