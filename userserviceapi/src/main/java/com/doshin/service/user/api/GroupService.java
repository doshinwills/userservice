package com.doshin.service.user.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doshin.service.user.model.GroupVO;

@Path("/group")
public interface GroupService {
	
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void save(GroupVO group);
	
	@GET
	@Path("/findByGroupId/{groupid}")
	@Produces(MediaType.APPLICATION_XML)
	public GroupVO findByGroupId(@PathParam("groupid") Integer groupId);

}
