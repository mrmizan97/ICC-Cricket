package com.mizan;

import com.mizan.config.HibernateConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.mizan.service"})
public class RootConfig {
	@Bean
	GlobalExceptionHandler globalExceptionHandler() {
		return new GlobalExceptionHandler();
	}

	@Bean
	HibernateConfig hibernateConfig() {
		return new HibernateConfig();
	}
}
