package com.doshin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.doshin.service.hibernate", "com.doshin.service.user.dao", "com.doshin.service.user.bao",  })
public class AppConfig {

}
