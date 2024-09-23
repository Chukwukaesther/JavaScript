package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Note;
import com.semicolon.africa.dto.request.*;
import com.semicolon.africa.dto.response.*;


public interface NoteService {
    AddNoteResponse addNote(AddNoteRequest addNoteRequest);
    FindNoteByTitleResponse getNoteByTitle(FindNoteRequest findNoteByTitleRequest);
    UpdateResponse updateNote(UpdateRequest updateRequest);
    DeleteNoteResponse deleteNote(DeleteNoteRequest deleteNoteRequest);
    Note findByTitle(String title);

    void save(Note note);
}
