package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Role;
import com.semicolon.farm_Links.data.model.User;
import com.semicolon.farm_Links.data.repository.UserRepository;
import com.semicolon.farm_Links.dto.request.LoginUserRequest;
import com.semicolon.farm_Links.dto.request.RegisterUserRequest;
import com.semicolon.farm_Links.dto.response.LoginUserResponse;
import com.semicolon.farm_Links.dto.response.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request, Role role) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = request.getPassword();

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (role == null) {
            throw new IllegalArgumentException("Role must be provided during registration");
        }

        User user = new User();
        BeanUtils.copyProperties(request, user);
//        user.setPassword(encoder.encode(password));
        user.setPassword(password);
        user.setRole(role);

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration successful");
        response.setUsername(user.getUsername());
        response.setRole(user.getRole().name());
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        return null;
    }

    @Override
    public Optional<User> findById(Long senderId) {
        return userRepository.findById(senderId);
    }

}


