package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.NoteRepository;
import com.semicolon.africa.data.repository.UserRepository;
import com.semicolon.africa.dto.request.AddNoteRequest;
import com.semicolon.africa.dto.request.LoginUserRequest;
import com.semicolon.africa.dto.request.RegisterUserRequest;
import com.semicolon.africa.dto.request.ShareNoteRequest;
import com.semicolon.africa.dto.response.AddNoteResponse;
import com.semicolon.africa.dto.response.LoginUserResponse;
import com.semicolon.africa.dto.response.ShareNoteResponse;
import com.semicolon.africa.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private  UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        noteRepository.deleteAll();
    }


    @Test
    public void testThatICanRegister() {
        RegisterUserRequest registerUser = new RegisterUserRequest();
        registerUser.setFirstName("Esther");
        registerUser.setLastName("favour");
        registerUser.setUsername("jane2133");
        registerUser.setPassword("Sweet123");
        registerUser.setEmail("Esther@gmail.com");
        userService.register(registerUser);
        assertEquals(1, userRepository.count());
    }


    @Test
    public void testThatTestCanLogin() {
        register();
        LoginUserRequest login = new LoginUserRequest();
        login.setUsername("Esther");
        login.setPassword("favour");
        LoginUserResponse response = new LoginUserResponse();
        response.setMessage("successfully logged in");
        assertEquals(1,userRepository.count());
    }

    private void register() {
        RegisterUserRequest register = new RegisterUserRequest();
        register.setFirstName("John");
        register.setLastName("mfon");
        register.setEmail("mfon@gmail.com");
        register.setPassword("password1");
        register.setUsername("janet");
        userService.register(register);
    }

    @Test
    public void testToAddNote(){
        register();
        AddNoteRequest request = new AddNoteRequest();
        request.setAuthor("janet");
        request.setTitle("chidera");
        request.setContent("My Note");
        AddNoteResponse response = addNewNote();
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Success");
    }

    private AddNoteResponse addNewNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("new title");
        request.setContent("new content");
        request.setAuthor("janet2133");
        return userService.addNote(request);
    }

    @Test
    public void testThatICanShareNote(){
        register();
        RegisterUserRequest register = new RegisterUserRequest();
        register.setFirstName("James");
        register.setLastName("mfon");
        register.setEmail("mfon@gmail.com");
        register.setPassword("password1");
        register.setUsername("james");
        userService.register(register);
        AddNoteRequest request = new AddNoteRequest();
        request.setAuthor("janet");
        request.setTitle("chidera");
        request.setContent("My Note");
        AddNoteResponse response = addNewNote();
        ShareNoteRequest request1 = new ShareNoteRequest();
        request1.setNoteTitle("new tittle");
        request1.setSenderUsername("janet");
        request1.setRecipientUsername("james");
        ShareNoteResponse response1 = userService.shareNote(request1);
        assertThat(response1).isNotNull();
    }

}