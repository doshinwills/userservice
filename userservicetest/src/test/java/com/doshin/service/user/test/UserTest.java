package com.doshin.service.user.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Assert;
import org.junit.Test;

import com.doshin.service.user.model.UserVO;

public class UserTest {

	@Test
	public void testUserSave() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		// create one todo
		UserVO userVO = new UserVO(0, "Admin", "Doshin", "Wills", "39800 Fremont", "gwills", "pass");
		userVO = service.path("user").path("save").request(MediaType.APPLICATION_XML)
				.post(Entity.entity(userVO, MediaType.APPLICATION_XML), UserVO.class);
		// Return code should be 201 == created resource
		Assert.assertNotEquals(userVO.getId(), 0);

	}

	@Test
	public void testUserUpdate() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		// create one todo
		UserVO userVO = new UserVO(0, "Admin", "Doshin", "Wills", "39800 Fremont", "gwills", "pass");
		userVO = service.path("user").path("save").request(MediaType.APPLICATION_XML)
				.post(Entity.entity(userVO, MediaType.APPLICATION_XML), UserVO.class);
		Assert.assertNotEquals(userVO.getId(), 0);
		
		userVO.setFirstname("Changed Doshin");
		userVO.setLastname("Changed Wills");
		
		service.path("user").path("update").request(MediaType.APPLICATION_XML)
		.post(Entity.entity(userVO, MediaType.APPLICATION_XML), UserVO.class);
		
		UserVO userVO2 = service.path("user").path("findByUserId").path(userVO.getId()+"").request(MediaType.APPLICATION_XML)
		.get(UserVO.class);
		
		Assert.assertEquals(userVO.getFirstname(), userVO2.getFirstname());
		Assert.assertEquals(userVO.getLastname(), userVO2.getLastname());

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/userserviceweb/rest").build();
	}

}
