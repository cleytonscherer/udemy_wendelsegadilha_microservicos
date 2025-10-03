package br.com.scherer.pedidos.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("RRest API - Pedidos").description("API para realização de Pedidos")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/license-2.0"))
                        .contact(new Contact()
                                .name("Cleyton Scherer")
                                .email("cleytonscherer@gmail.com"))
        );
    }
}
