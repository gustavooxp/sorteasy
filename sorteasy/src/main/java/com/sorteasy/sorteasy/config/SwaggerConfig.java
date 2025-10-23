package com.sorteasy.sorteasy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI sorteasyOpenAPI() {
        return new OpenAPI()
            .info(new Info()
            .title("Sorteasy API")
            .version("1.0.0")
            .description("Documentação gerada automaticamente para o projeto Sorteasy")
            .contact(new Contact().name("Gustavo").email("gustavo@gmail.com")));
    }
}
