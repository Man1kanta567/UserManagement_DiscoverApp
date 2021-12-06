package com.mnt.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class MainConfiguration 
{
	
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder)
	{
		return restTemplateBuilder.setReadTimeout(Duration.ofMillis(2000)).build();
	}

	
	@Bean
	public Docket getDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.mnt.controller")).build();
	}
	
	
}
