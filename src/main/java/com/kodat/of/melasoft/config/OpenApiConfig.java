package com.kodat.of.melasoft.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Invoice API")
                        .version("1.0")
                        .description("Invoice Processing API")
                        .contact(new Contact()
                                .name("Kodat")
                                .email("farukkodat@gmail.com")));
    }
}