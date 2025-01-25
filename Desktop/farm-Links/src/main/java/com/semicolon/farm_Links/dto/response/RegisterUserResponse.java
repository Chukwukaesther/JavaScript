package com.semicolon.farm_Links.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponse {
    private String message;
    private String Username;
    private String role;
}
