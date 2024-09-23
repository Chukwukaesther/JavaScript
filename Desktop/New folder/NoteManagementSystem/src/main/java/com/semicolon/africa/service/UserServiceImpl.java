package com.semicolon.africa.service;



import com.semicolon.africa.data.model.Note;
import com.semicolon.africa.data.model.User;
import com.semicolon.africa.data.repository.UserRepository;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.UserNotFoundException;
import com.semicolon.africa.exceptions.IncorrectRequirementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private NoteService noteService;

    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        validateUserUsername(registerUserRequest.getUsername());
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setEmail(registerUserRequest.getEmail());
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration Successful");
        return response;
    }

    private void validateUserUsername(String username) {
        if(userRepository.existsByUsername(username))
            throw new IllegalStateException("Username already exist");
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null  || !user.getPassword().equals(loginRequest.getPassword())) {
            throw new IncorrectRequirementException("incorrect password or username");
        }
        user.setLoggedIn(true);
        userRepository.save(user);
        LoginUserResponse response = new LoginUserResponse();
        response.setMessage("Logged in successfully");
        return response;
    }

    @Override
    public FindUserResponse findUserByEmail(FindUserRequest finduserRequest) {
        User user = userRepository.findUserByEmail(finduserRequest.getEmail());
        if (!user.getEmail().equals(finduserRequest.getEmail())) {
            throw new UserNotFoundException("Uer not found");
        }
        FindUserResponse response = new FindUserResponse();
        response.setMessage("User found");

        return response;
    }



    @Override
    public LogoutUserResponse logout(LogoutUserRequest logoutRequest) {
        User user = userRepository.findByUsername(logoutRequest.getPassword());
        if(user.getPassword().equals(logoutRequest.getPassword())){
            throw new IllegalStateException("incorrect password");
        }
        LogoutUserResponse response = new LogoutUserResponse();
        response.setMessage("logged out successfully");
        return response;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }

        return user;

    }

    @Override
    public void saveUser(User sender) {
        userRepository.save(sender);
    }

    @Override
    public AddNoteResponse addNote(AddNoteRequest request) {
        AddNoteResponse response = noteService.addNote(request);
        User owner = userRepository.findByUsername(request.getAuthor());
        Note note = noteService.findByTitle(request.getTitle());
        note.setOwner(owner);
        noteService.save(note);
        return response;
    }

    @Override
    public ShareNoteResponse shareNote(ShareNoteRequest request1) {
        Note note = noteService.findByTitle(request1.getNoteTitle());
        User recipient = userRepository.findByUsername(request1.getRecipientUsername());
        User sender = userRepository.findByUsername(request1.getSenderUsername());
        recipient.getNotes().add(note);
        userRepository.save(recipient);
        ShareNoteResponse response = new ShareNoteResponse();
        response.setMessage("Note shared successfully");
        return response;
    }


}
