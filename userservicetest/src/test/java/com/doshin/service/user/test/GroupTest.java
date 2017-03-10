package com.doshin.service.user.test;

import java.net.URI;
import java.util.ArrayList;
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

import com.doshin.service.user.model.GroupVO;
import com.doshin.service.user.model.RightVO;

public class GroupTest {

	@Test
	public void testGroupSave() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		// create one todo
		RightVO rigth1 = new RightVO(null, "right1", new Date(), new Date(), new ArrayList<GroupVO>());
		RightVO rigth2 = new RightVO(null, "right1", new Date(), new Date(), new ArrayList<GroupVO>());

		GroupVO groupVO = new GroupVO(null, "group1", new Date(), new Date(), new ArrayList<RightVO>());

		groupVO.getRightList().add(rigth1);
		groupVO.getRightList().add(rigth2);

		rigth1.getGroupList().add(groupVO);
		rigth2.getGroupList().add(groupVO);

		Invocation.Builder invocationBuilder = service.path("group").path("save").request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		invocationBuilder.post(Entity.entity(groupVO, MediaType.APPLICATION_XML));
	}

	@Test
	public void testGroupGet() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		Invocation.Builder invocationBuilder = service.path("group").path("findByGroupId").path("1").request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		GroupVO groupVO = invocationBuilder.get(GroupVO.class);

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/userserviceweb/rest").build();
	}

}
