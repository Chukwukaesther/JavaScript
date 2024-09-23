package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
