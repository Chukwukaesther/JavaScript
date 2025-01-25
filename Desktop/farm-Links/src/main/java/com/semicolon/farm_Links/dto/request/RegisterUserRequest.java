package com.semicolon.farm_Links.dto.request;

import com.semicolon.farm_Links.data.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private Role role;


}
