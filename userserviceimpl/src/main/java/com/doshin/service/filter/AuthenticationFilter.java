package com.doshin.service.filter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.doshin.service.user.bao.UserBao;
import com.doshin.service.user.model.UserVO;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource").build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
			.entity("Access blocked for all users !!").build();

	@Autowired
	UserBao userBao;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		final MultivaluedMap<String, String> headers = requestContext.getHeaders();
		final List<String> headerList = headers.get(AUTHORIZATION_PROPERTY);

		if (headerList == null || headerList.size() == 0 || headerList.get(0) == null
				|| headerList.get(0).trim() == "") {
			requestContext.abortWith(ACCESS_FORBIDDEN);
			return;
		}

		String userPassEncoded = headerList.get(0);
		userPassEncoded = userPassEncoded.replaceFirst(AUTHENTICATION_SCHEME + " ", "");
		String userPass = new String(Base64.getDecoder().decode(userPassEncoded));

		if (userPass.indexOf(":") == -1) {
			requestContext.abortWith(ACCESS_FORBIDDEN);
			return;
		}

		String user = userPass.substring(0, userPass.indexOf(":"));
		String pass = userPass.substring(userPass.indexOf(":") + 1);

//		UserVO userVO = userBao.findByUserId(1);
//
//		if (!"pass".equals(pass)) {
//			requestContext.abortWith(ACCESS_DENIED);
//			return;
//		}

	}

}
