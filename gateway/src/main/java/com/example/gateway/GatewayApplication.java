package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewayApplication {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public GatewayApplication(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @RequestMapping("/lb/echo")
    public Mono<String> lbEcho() {
        return loadBalancedWebClientBuilder.build().get().uri("http://echo-app/echo")
                .retrieve().bodyToMono(String.class);
    }

    @RequestMapping("/eureka/echo")
    public Mono<String> eurekaEcho() {
        return loadBalancedWebClientBuilder.build().get().uri("lb://echo-app/echo")
                .retrieve().bodyToMono(String.class);
    }
}