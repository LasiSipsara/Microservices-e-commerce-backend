package com.lasinisipsara.order_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderServiceApi(){
        return new OpenAPI()
                .info(new Info().title("order-service-api")
                        .description("this is the api documentation for order service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("you can refer to the product service wiki documentation")
                        .url("http://product-service-dumy=url/docs"));


    }
}
