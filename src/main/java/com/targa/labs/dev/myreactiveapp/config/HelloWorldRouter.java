package com.targa.labs.dev.myreactiveapp.config;

import com.targa.labs.dev.myreactiveapp.rest.HelloWorldHandler;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class HelloWorldRouter {

    @ApiOperation(value = "test helloRouterFunction")
    @Bean
    public RouterFunction<ServerResponse> helloRouter(HelloWorldHandler helloWorldHandler) {
        return route(GET("/hello"),
                helloWorldHandler::sayHello);
    }

}
