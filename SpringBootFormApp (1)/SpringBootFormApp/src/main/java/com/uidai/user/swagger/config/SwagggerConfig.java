package com.uidai.user.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * This class is used to provide Swagger Confiuration
 * 
 * @author Rituraj
 *
 */
@Configuration
public class SwagggerConfig {

	/**
	 * This method used to set all details link apiInfo
	 * location of restControllers or paths	
	 * @return
	 */
	@Bean
	public Docket docket() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(basePackage("com.uidai.user.rest.resources"))
					.paths(any())
					.build()
					.apiInfo(apiInfo1());
		return docket;
		
	}
	private ApiInfo apiInfo1() {
		ApiInfo builder=new ApiInfoBuilder()
								.title("RITURAJ TECH SOLUTION Pvt.Ltd")
								.description("User Apllication ")
								.contact(new Contact("Rituraj Rawat","https://github.com/rawatrituraj653", "Rituraj4@gmail.com"))
								.license("Apache 2.0")
								.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
								.build();
		return builder;
	}
	
}
