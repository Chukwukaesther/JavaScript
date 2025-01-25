package com.semicolon.farm_Links.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserRequest {
    private String username;
    private String password;
}
