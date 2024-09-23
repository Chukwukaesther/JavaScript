package com.semicolon.africa.controllers;


import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.NoteManagementException;
import com.semicolon.africa.exceptions.UserNotFoundException;
import com.semicolon.africa.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            RegisterUserResponse response = userService.register(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        } catch (NoteManagementException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }

    @PostMapping("api/login")
    public ResponseEntity<?>login(@RequestBody LoginUserRequest loginUserRequest){
        try{
            LoginUserResponse response = userService.login(loginUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        } catch (NoteManagementException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }

    @PostMapping("api/findUserByEmail")
    public ResponseEntity<?> findUserByEmail(@RequestBody FindUserRequest findUserRequest){
        try{
            FindUserResponse response = userService.findUserByEmail(findUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        }catch (UserNotFoundException exception){
            return new ResponseEntity<>(new ApiResponse(false,exception), BAD_REQUEST);
        }
    }

        @PostMapping("/shareNote")
    public ResponseEntity<?> shareNote(@RequestBody ShareNoteRequest request){
        try{
            ShareNoteResponse response = userService.shareNote(request);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        }
        catch (NoteManagementException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }@PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutUserRequest logoutUserRequest){
        try{
            LogoutUserResponse response = userService.logout(logoutUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,response), CREATED);
        }
        catch (UserNotFoundException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }


}