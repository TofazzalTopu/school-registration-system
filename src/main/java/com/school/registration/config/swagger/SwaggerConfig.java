package com.school.registration.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.school.registration.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private Contact contact() {
        Contact contact = new Contact(
                "School Registration System",
                "http://school.registration.com/",
                "info@school.registration.com"
        );
        return contact;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("School Registration System Api")
                .description("School Registration System Api")
                .version("1.0")
                .license("School Registration System Service")
                .licenseUrl("http://school.registration.com/")
                .contact(contact())
                .build();
    }
}
