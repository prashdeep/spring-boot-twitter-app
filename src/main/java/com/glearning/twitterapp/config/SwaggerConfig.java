package com.glearning.twitterapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket customImplementation(){
        System.out.println("Came inside the custom implementation");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.glearning.twitterapp"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("REST Api Documentation",
                "REST Api Documentation of Twitter application",
                "1.0",
                "urn:tos",
                new Contact("Developer", "http://greatlearning.com", "support@glearning.com"),
                "Apache 2.0", "http://www.glearning.com/license",
                new ArrayList<VendorExtension>());
    }
}
