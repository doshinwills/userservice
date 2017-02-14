package com.doshin.service.user.impl;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import com.doshin.service.user.model.UserVO;

public class RestDemoServiceIT {

	@Test
	public void testGetPodcasts() throws IOException {

		ClientConfig clientConfig = new ClientConfig();

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target("http://localhost:8080/ASampleWebProject/user/testpostservice");

		Builder request = webTarget.request(MediaType.APPLICATION_XML);

		UserVO user = new UserVO();
		user.setId(123);
		user.setUsertype("Admin");
		user.setFirstname("Doshin");
		user.setLastname("Wills");
		user.setAddress("39800 Fremont");
		user.setUsername("gwills");
		user.setPassword("pass");

		final Response post = request.post(Entity.entity(user, MediaType.APPLICATION_XML));

		UserVO user2 = post.readEntity(UserVO.class);

		System.out.println(user2);

	}

	@Test
	public void testGetPodcast2() throws IOException {

		ClientConfig clientConfig = new ClientConfig();

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target("http://localhost:8080/ASampleWebProject/user//testpostservice/123")
				.property("Content-Type", MediaType.APPLICATION_XML);
		
		Builder request = webTarget.request(MediaType.APPLICATION_XML);

		
		final Response post = request.get();
		
		System.out.println(post.getStatus());

		UserVO user2 = post.readEntity(UserVO.class);

		System.out.println(user2);
	}

}
