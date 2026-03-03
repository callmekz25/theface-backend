package com.codewithkz.apigateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

//                .route( p -> p
//                        .path("/api/auth/**")
//                        .uri("lb://auth-service"))
                .route(p -> p
                        .path("/v1/products/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://product-service"))
//                .route(p -> p
//                        .path("/api/inventories/**")
//                        .uri("lb://inventory-service"))
//                .route(p -> p
//                        .path("/api/orders/**")
//                        .uri(orderService))
//                .route(p -> p
//                        .path("/api/payments/**")
//                        .uri(paymentService))
                .build();
    }
}
