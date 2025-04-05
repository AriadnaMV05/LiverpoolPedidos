package com.liverpool.pedidosusuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
public class SwaggerConf {
    @Configuration
    public class SwaggerConfig {
        @Bean
        public OpenAPI apiInfo() {
            return new OpenAPI()
                    .info(new Info()
                            .title("API Gestion de pedidos- Liverpool")
                            .description("Documentación para gestionar clientes y pedidos.")
                            .version("1.0.0"));

        }
    }
}
