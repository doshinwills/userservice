package com.doshin.service.user.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "right")
public class RightDO {

	@Id
	@Column(name = "rightid")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer rightId;

	@Column(name = "name")
	private String name;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "updatedon")
	private Date updatedOn;

	@ManyToMany(mappedBy="rightList")
	List<GroupDO> groupList;

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
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

	public List<GroupDO> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupDO> groupList) {
		this.groupList = groupList;
	}

	

}
