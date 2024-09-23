package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.NoteRepository;
import com.semicolon.africa.data.repository.UserRepository;
import com.semicolon.africa.dto.request.AddNoteRequest;
import com.semicolon.africa.dto.response.AddNoteResponse;
import com.semicolon.africa.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NoteServiceImplTest {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        noteRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void TestThatICanAddNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setAuthor("Asa1");
        request.setTitle("chidera");
        request.setContent("My Note");
        noteService.addNote(request);
        AddNoteResponse response = addNewNote();
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Success");
    }

    private AddNoteResponse addNewNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("new title");
        request.setContent("new content");
        request.setAuthor("janet2133");
        return noteService.addNote(request);
    }



}