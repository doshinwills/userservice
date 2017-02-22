package com.doshin.service.user.test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doshin.service.user.model.GroupVO;
import com.doshin.service.user.model.UserPasswordVO;
import com.doshin.service.user.model.UserVO;

public class UserTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("in before class");
	}

	// execute only once, in the end
	@AfterClass
	public static void afterClass() {
		System.out.println("in after class");
	}

	// execute for each test, before executing test
	@Before
	public void before() {
		System.out.println("in before");
	}

	// execute for each test, after executing test
	@After
	public void after() {
		System.out.println("in after");
	}

	@Test
	public void testUserSave() throws JAXBException {

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		// create one todo
		UserPasswordVO passwordVO = new UserPasswordVO(null, "sec", new Date(), new Date());
		List<GroupVO> groupList = new ArrayList<GroupVO>();
		groupList.add(getGroup());

		UserVO userVO = new UserVO(null, "Geo Doshin Wills", "Doshin", "Wills", new Date(), new Date(), passwordVO,
				groupList);

		Invocation.Builder invocationBuilder = service.path("user").path("save").request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		userVO = invocationBuilder.post(Entity.entity(userVO, MediaType.APPLICATION_XML), UserVO.class);
		// Return code should be 201 == created resource
		System.out.println("Save - " + userVO);
	}

	@Test
	public void testUserGet() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		Invocation.Builder invocationBuilder = service.path("user").path("findByUserId").path("1")
				.request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		UserVO userVO = invocationBuilder.get(UserVO.class);
		System.out.println("Get - " + userVO);

	}

	private GroupVO getGroup() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		Invocation.Builder invocationBuilder = service.path("group").path("findByGroupId").path("1")
				.request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		GroupVO groupVO = invocationBuilder.get(GroupVO.class);
		System.out.println("Get - " + groupVO);

		return groupVO;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/userserviceweb/rest").build();
	}

}
