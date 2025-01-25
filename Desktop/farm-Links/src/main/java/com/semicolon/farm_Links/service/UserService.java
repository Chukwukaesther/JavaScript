package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Role;
import com.semicolon.farm_Links.data.model.User;
import com.semicolon.farm_Links.dto.request.LoginUserRequest;
import com.semicolon.farm_Links.dto.request.RegisterUserRequest;
import com.semicolon.farm_Links.dto.response.LoginUserResponse;
import com.semicolon.farm_Links.dto.response.RegisterUserResponse;

import java.util.Optional;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request, Role role);
    LoginUserResponse loginUser(LoginUserRequest request);

    Optional<User> findById(Long senderId);
}
