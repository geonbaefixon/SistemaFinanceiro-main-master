package com.Projeto.SistemaFinanceiro.infra.springdoc;

@Operation(security = { @SecurityRequirement(name = "bearer-key") })
public class SpringDocConfigurations{
    @Bean
     public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .components(new Components()
        .addSecuritySchemes("bearer-key",
        new SecurityScheme().type(SecurityScheme.Type.HTTP)
        .scheme("bearer").bearerFormat("JWT")))
        }



}