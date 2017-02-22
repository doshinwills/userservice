package com.doshin.service.user.test;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import com.doshin.service.user.model.UserPasswordVO;
import com.doshin.service.user.model.UserVO;

public class UserTest {

//	@Test
//	public void testUserSave() {
//		ClientConfig config = new ClientConfig();
//		Client client = ClientBuilder.newClient(config);
//		WebTarget service = client.target(getBaseURI());
//
//		// create one todo
//		UserPasswordVO passwordVO = new UserPasswordVO(null, "sec", new Date(), new Date());
//		UserVO userVO = new UserVO(null, "Geo Doshin Wills", "Doshin", "Wills", new Date(), new Date(), passwordVO);
//		System.out.println(userVO);
//
//		Invocation.Builder invocationBuilder = service.path("user").path("save").request(MediaType.APPLICATION_XML);
//		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");
//
//		userVO = invocationBuilder.post(Entity.entity(userVO, MediaType.APPLICATION_XML), UserVO.class);
//		// Return code should be 201 == created resource
//		System.out.println("Save - " + userVO);
//	}

	@Test
	public void testUserGet() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		Invocation.Builder invocationBuilder = service.path("user").path("findByUserId").path("1").request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		UserVO userVO = invocationBuilder.get(UserVO.class);
		System.out.println("Get - " + userVO);

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/userserviceweb/rest").build();
	}

}
