package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Note;
import com.semicolon.africa.data.repository.NoteRepository;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.NoteNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;

    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        validateNoteTitle(addNoteRequest.getTitle());
        Note note = new Note();
        note.setTitle(addNoteRequest.getTitle());
        note.setAuthor(addNoteRequest.getAuthor());
        note.setDateCreated(LocalDateTime.now());
        noteRepository.save(note);
        AddNoteResponse response = new AddNoteResponse();
        response.setMessage("Successfully added note");
        return response;
    }

    private void validateNoteTitle(String title) {
        boolean existsByTitle = noteRepository.existsByTitle(title);
        if (existsByTitle) {
            throw new IllegalArgumentException("Title already exists");
        }
    }

    @Override
    public FindNoteByTitleResponse getNoteByTitle(FindNoteRequest findNoteByTitleRequest) {
        Note note = findByTitle(findNoteByTitleRequest.getTitle());
        FindNoteByTitleResponse response = new FindNoteByTitleResponse();
        response.setNoteId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());
        response.setDateCreated(note.getDateCreated());
        return response;
    }

    public Note findByTitle(String title) {
        return noteRepository.findByTitle(title);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public UpdateResponse updateNote(UpdateRequest updateRequest) {
        Note note = noteRepository.findByTitle(updateRequest.getTitle());
         if (note == null) {
             throw new NoteNotFoundException("Note not found");
         }
         note.setContent(updateRequest.getContent());
         note.setTitle(updateRequest.getTitle());
         noteRepository.save(note);
         UpdateResponse response = new UpdateResponse();
         response.setMessage("note updated successfully");
        return response;
    }


    @Override
    public DeleteNoteResponse deleteNote(DeleteNoteRequest deleteNoteRequest) {
        Note note = noteRepository.findByTitle(deleteNoteRequest.getTitle());
        if (note == null) {
            throw new NoteNotFoundException("Note not found");
        }
        noteRepository.delete(note);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Note deleted successfully");
        return response;
    }
}
