package com.calculatorapirest.config;


import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.calculatorapirest.serialization.converter.YamlJackson2HttpMessageConverter;

/**
 * Metodo de tratamento de serelizaçao de xml, json e yaml
 */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	public void extendMessageConverter(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		/*
		 * Via Extension. localhost:8090/person.xml
		 * Via Extension. localhost:8090/person.json
		 */
		/*
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
		*/
		
		
		/*
		 * Via QUERY PARAM. localhost:8090/person?mediaType=xml
		 * Via QUERY PARAM. localhost:8090/person?mediaType=json
		 */
		
		/*
		 configurer.favorPathExtension(false)
		.favorParameter(true)
		.parameterName("mediaType")
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
		 */
		
		/*
		 * Via Headers postman. localhost:8090/person
		 * Via Headers postman. localhost:8090/person
		 */
		
		/*
		 configurer.favorPathExtension(false)
		 .favorParameter(true)
		 .ignoreAcceptHeader(false)
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("json", MediaType.APPLICATION_JSON)
		 .mediaType("xml", MediaType.APPLICATION_XML);
		 */
		
		/*
		 * serializar YAML. localhost:8090/person
		 */
		
		
		 configurer.favorPathExtension(false)
		 .favorParameter(false)
		 .ignoreAcceptHeader(false)
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("json", MediaType.APPLICATION_JSON)
		 .mediaType("xml", MediaType.APPLICATION_XML)
		 .mediaType("x-yaml", MEDIA_TYPE_YML);
		 
		
		
	}
}
