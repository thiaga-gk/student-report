package com.student.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.student.report"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                .directModelSubstitute(LocalDateTime.class, String.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Student Report")
                .description("Student Report API description")
                .contact(new Contact("Student Report",
                        "https://studentreport.io",
                        "support@studentreport.io"))
                .version("1.0.0")
                .build();
    }
}
