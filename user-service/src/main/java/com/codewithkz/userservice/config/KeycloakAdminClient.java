package com.codewithkz.userservice.config;

import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class KeycloakAdminClient {
    private String serverUrl;
    private String realm;
    private String clientId;
    private String username;
    private String password;

    @Bean
    public Keycloak keycloakAdminClient() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .username(username)
                .password(password)
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }

    @Bean
    RealmResource realmResource(Keycloak keycloak) {
        return keycloak.realm(this.realm);
    }

    @Bean
    UsersResource usersResource(RealmResource realmResource) {
        return realmResource.users();
    }

    @Bean
    RolesResource rolesResource(RealmResource realmResource) {
        return realmResource.roles();
    }
}
