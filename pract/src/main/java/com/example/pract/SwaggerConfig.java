package com.example.pract;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.v3.oas.models.info.Info;

// Настройки для метода swagger

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/patients/**")  // Указываем путь, для которого будет генерироваться документация
                .build();
    }

    @Bean
    public Info apiInfo() {
        return new Info().title("Patient API").description("API for managing patient information").version("1.0");
    }
}