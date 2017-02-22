package com.doshin.service.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "group")
public class GroupVO {

	private Integer groupId;
	private String name;
	private Date createdOn;
	private Date updatedOn;

	List<RightVO> rightList = new ArrayList<RightVO>();

	public GroupVO() {
		super();
	}

	public GroupVO(Integer groupId, String name, Date createdOn, Date updatedOn, List<RightVO> rightList) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.rightList = rightList;
	}

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

	public List<RightVO> getRightList() {
		return rightList;
	}

	public void setRightList(List<RightVO> rightList) {
		this.rightList = rightList;
	}

	@Override
	public String toString() {
		return "GroupVO [groupId=" + groupId + ", name=" + name + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", rightList=" + rightList.size() + "]";
	}

}