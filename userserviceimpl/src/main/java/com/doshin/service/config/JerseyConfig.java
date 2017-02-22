package com.doshin.service.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.doshin.service.filter.AuthenticationFilter;

public class JerseyConfig  extends ResourceConfig{
	public JerseyConfig() {
	        register(AuthenticationFilter.class);
	}
}
