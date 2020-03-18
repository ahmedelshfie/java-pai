package com.eventsource.util;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket produtApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eventsource.api"))
				.paths(regex("/event.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("SURCE EVENT", "Development Api Rest with Spring Boot", "0.1", "Tems of Services",
				new Contact("Rafael", "https://www.linkedin.com/in/rafaelcarvalhocaetano/", "rapha.pse@outlook.com"), 
				"Version 0.1", "http:heroku.app/api", new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
