package com.doshin.service.user.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doshin.service.user.model.UserVO;

@Path("/user")
public interface UserService {
	
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public UserVO save(UserVO user);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void update(UserVO user);

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void delete(UserVO user);

	@GET
	@Path("/findByUserId/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public UserVO findByUserId(@PathParam("userid") Integer userId);

}
