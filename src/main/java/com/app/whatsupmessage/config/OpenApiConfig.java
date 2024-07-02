package com.app.whatsupmessage.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        String securitySchemeName = "Auth JWT";
        return new OpenAPI()
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName)
                )
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("Bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .info(apiInfo());
    }

    @Bean
    public GroupedOpenApi privateApi() {
        return GroupedOpenApi.builder()
                .group("private-apis")
                .pathsToMatch("/**")
                .packagesToScan("com.app")
                .pathsToExclude("/actuator/**")
                .build();
    }

    private Info apiInfo() {
        return new Info()
                .title("Bitcoin App API")
                .description("API Bitcoin")
                .version("1.0")
                .contact(apiContact())
                .license(apiLicence());
    }

    private Contact apiContact() {
        return new Contact()
                .name("Bitcoin")
                .email("https://www.eatlbd.com/index.php?r=site/contact")
                .url("https://www.eatlbd.com/");
    }

    private License apiLicence() {
        return new License()
                .name("MIT Licence")
                .url("https://opensource.org/licenses/mit-license.php");
    }
}

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Collections;
//import java.util.List;
//
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .securityContexts(Collections.singletonList(securityContext()))
//                .securitySchemes(List.of(apiKey())).select()
//                .apis(RequestHandlerSelectors.basePackage("com.app.whatsupmessage.resource"))
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey(
//                "JWT",
//                "Authorization",
//                "header"
//        );
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope scope = new AuthorizationScope(
//                "global",
//                "accessEverything"
//        );
//        AuthorizationScope[] scopes = new AuthorizationScope[1];
//        scopes[0] = scope;
//        return List.of(new SecurityReference("JWT", scopes));
//    }
//
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//
//                "Bitcoin App Service API",
//                "API for web and mobile client",
//                "1.0",
//                "www.bitcoincanvass.net",
//                new Contact(
//                        "Support",
//                        "bitcoincanvass.net/api/support",
//                        "info@eatlbd.net"
//                ),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0",
//                Collections.emptyList()
//        );
//    }
//}

