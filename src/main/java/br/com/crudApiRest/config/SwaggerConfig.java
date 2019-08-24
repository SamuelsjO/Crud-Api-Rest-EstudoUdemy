package br.com.crudApiRest.config;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.crudApiRest"))
				.paths(PathSelectors.any())
				.build().apiInfo(ApiInfo());
	}

	private ApiInfo ApiInfo() {
		return new ApiInfo("RESTful Api with Srping Boot", 
				"My course about Api with Spring of Udemy", 
				"V1", "Terms of Service url", 
				 new Contact("Samuel Olivera", 
				 "https://www.linkedin.com/in/samuel-jose-souza-oliveira-81b1177b/", 
				 "samucagm@rocketmail.com"), 
				"LIncese of API", "Lincese of URL Api",Collections.emptyList());
		
	}
}
