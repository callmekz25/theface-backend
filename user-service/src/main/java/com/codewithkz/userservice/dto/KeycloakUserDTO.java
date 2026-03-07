package com.codewithkz.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeycloakUserDTO {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
}
