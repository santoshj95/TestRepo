package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProperty {

	@Value("${basic.property1}")
	public String property;

	public String getProperty() {
		System.out.println("********getprop");
		return property;
	}

	public void setProperty(String property) {
		System.out.println("********setprop");
		this.property = property;
	}		
}
