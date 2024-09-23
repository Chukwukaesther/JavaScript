package com.semicolon.africa.controllers;
import com.semicolon.africa.dto.request.AddNoteRequest;
import com.semicolon.africa.dto.request.DeleteNoteRequest;
import com.semicolon.africa.dto.request.FindNoteRequest;
import com.semicolon.africa.dto.request.UpdateRequest;
import com.semicolon.africa.dto.response.*;
import com.semicolon.africa.exceptions.NoteManagementException;
import com.semicolon.africa.service.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/notes")
public class NoteController {
    @Autowired
    private NoteServiceImpl noteService;

    @PostMapping("/addNote")
    public ResponseEntity<?>AddNote(@RequestBody AddNoteRequest addNoteRequest){
        try{
           AddNoteResponse result = noteService.addNote(addNoteRequest);
           return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(NoteManagementException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("/findByTitle")
    public ResponseEntity<?> findByTitle(@RequestBody FindNoteRequest request){
        try{
            FindNoteByTitleResponse response = noteService.getNoteByTitle(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (NoteManagementException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }
    @PostMapping("/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody UpdateRequest request) {
        try{
            UpdateResponse response = noteService.updateNote(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (NoteManagementException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }



    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteNoteRequest request) {
        try {
            DeleteNoteResponse response = noteService.deleteNote(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (NoteManagementException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }


    }
}