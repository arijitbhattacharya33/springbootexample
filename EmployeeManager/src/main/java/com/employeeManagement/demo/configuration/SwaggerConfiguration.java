package com.employeeManagement.demo.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {

	@Bean
	public Docket swaggerCustomConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.employeeManagement.demo.controller"))
				.paths(PathSelectors.ant("/api/*")).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Employee Manager API", "Sample API details for Employee Manager", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Arijit Bhattacharya", "http://arijiitbhattacharya.com",
						"arijitbhattacharya33@yahoo.com"),
				"Api Licence not required", "https://spring.io", Collections.emptyList());
	}
}
