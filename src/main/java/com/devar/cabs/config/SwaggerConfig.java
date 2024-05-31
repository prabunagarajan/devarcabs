package com.devar.cabs.config;

import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ApiInfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ModelReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		final ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("X-Authorization").modelRef((ModelReference) new ModelRef("string"))
				.parameterType("header").defaultValue("").required(false).build();
		final List<Parameter> aParameters = new ArrayList<Parameter>();
		aParameters.add(aParameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.devar"))
				.paths(PathSelectors.any()).build().apiInfo(this.metaData())
				.globalOperationParameters((List) aParameters);
	}

	private ApiInfo metaData() {
		final ApiInfo apiInfo = new ApiInfo("Devar Cabs", "", "1.0", "Terms of service",
				new Contact("PRABU", "", ""), "", "");
		return apiInfo;
	}
	
}