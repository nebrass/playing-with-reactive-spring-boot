package com.targa.labs.dev.myreactiveapp.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HelloWorldHandler {

    @ApiOperation(value = "test HelloWorldHandler")
    public Mono<ServerResponse> sayHello(ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("Hello World!"), String.class);
    }
}
