package com.semicolon.africa.service;

import com.semicolon.africa.data.model.User;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;

public interface UserService {

    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
    LoginUserResponse login(LoginUserRequest loginRequest);
    FindUserResponse findUserByEmail(FindUserRequest finduserRequest);
    LogoutUserResponse logout(LogoutUserRequest logoutRequest);
    User findByUsername(String username);
    void saveUser(User sender);

    AddNoteResponse addNote(AddNoteRequest request);

    ShareNoteResponse shareNote(ShareNoteRequest request1);
}
