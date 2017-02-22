package com.doshin.service.user.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "right")
public class RightVO {

	private Integer rightId;

	private String name;

	private Date createdOn;

	private Date updatedOn;

	private List<GroupVO> groupList;

	public RightVO() {
		super();
	}

	public RightVO(Integer rightId, String name, Date createdOn, Date updatedOn, List<GroupVO> groupList) {
		super();
		this.rightId = rightId;
		this.name = name;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.groupList = groupList;
	}

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
	
	@XmlTransient
	public List<GroupVO> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupVO> groupList) {
		this.groupList = groupList;
	}

	@Override
	public String toString() {
		return "RightVO [rightId=" + rightId + ", name=" + name + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", groupList=" + groupList + "]";
	}

}
