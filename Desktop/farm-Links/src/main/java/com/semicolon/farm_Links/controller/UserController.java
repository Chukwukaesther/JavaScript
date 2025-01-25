package com.semicolon.farm_Links.controller;
import com.semicolon.farm_Links.data.model.Role;
import com.semicolon.farm_Links.dto.request.LoginUserRequest;
import com.semicolon.farm_Links.dto.request.RegisterUserRequest;
import com.semicolon.farm_Links.dto.response.ApiResponse;
import com.semicolon.farm_Links.dto.response.LoginUserResponse;
import com.semicolon.farm_Links.dto.response.RegisterUserResponse;
import com.semicolon.farm_Links.exception.FarmLinkException;
import com.semicolon.farm_Links.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@NonNull
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/RegisterUser")
    public ResponseEntity<?> registerUser(
            @RequestBody RegisterUserRequest request) {
        try {
            RegisterUserResponse result = userService.registerUser(request, request.getRole());
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/LoginUser")
    public ResponseEntity<?> loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            LoginUserResponse result = userService.loginUser(loginUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);

        } catch (FarmLinkException  exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

}
