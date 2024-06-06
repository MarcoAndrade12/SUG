package com.SUG.FLORA.controllerRest;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API SUG-FLORA")
                        .version("1.0")
                        .description("Documentação dos end-points"));
    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> openApi.getPaths().values()
                .forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                    operation.addParametersItem(new Parameter()
                            .in(ParameterIn.HEADER.toString())
                            .schema(new StringSchema())
                            .name("X-Custom-Header")
                            .required(false));
                }));
    }
}
