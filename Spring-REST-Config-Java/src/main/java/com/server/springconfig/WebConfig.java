package com.server.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.server.controller.PersonController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.server")
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Since we don't have any controller logic, simpler to just
	 * define controller for page using View Controller.we need to extend 
	 * the WebMvcConfigurerAdapter to get this functionality	 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	
	/*@Bean
	public PersonController getPersonController() {
		return new PersonController();
	}*/

	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
