package com.targa.labs.dev.myreactiveapp.config;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.net.URI;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfiguration {

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        Mono<ServerResponse> build = ServerResponse.temporaryRedirect(URI.create("swagger-ui.html")).build();
        return RouterFunctions.route(RequestPredicates.GET("/swagger"), request -> build);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "Nebrass Lamouchi",
                "https://blog.nebrass.fr",
                "lnibrass@gmail.com"
        );

        return new ApiInfoBuilder()
                .title("Playing with Spring Webflux")
                .description("Sample application for my blog post 'Playing with Reactive Spring Boot'")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
