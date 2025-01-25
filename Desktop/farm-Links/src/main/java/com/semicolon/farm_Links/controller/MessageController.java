package com.semicolon.farm_Links.controller;

import com.semicolon.farm_Links.data.model.Message;
import com.semicolon.farm_Links.dto.request.MessageRequest;
import com.semicolon.farm_Links.dto.response.ApiResponse;
import com.semicolon.farm_Links.dto.response.MessageResponse;
import com.semicolon.farm_Links.exception.FarmLinkException;
import com.semicolon.farm_Links.service.MessageService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@NonNull
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;


    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody MessageRequest messageRequest) {
        try {
            MessageResponse result = messageService.sendMessage(messageRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }


    @GetMapping("/conversations")
    public ResponseEntity<?> getAllConversations() {
        try {
            List<MessageResponse> conversations = messageService.getConversation()
                    .stream()
                    .map(this::convertToMessageResponse)
                    .toList();
            return new ResponseEntity<>(new ApiResponse(true, conversations), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }
    private MessageResponse convertToMessageResponse(Message message) {
        return getMessageResponse(message);
    }

    public static MessageResponse getMessageResponse(Message message) {
        MessageResponse response = new MessageResponse();
        response.setId(message.getId());
        response.setSenderId(message.getSender().getId());
        response.setReceiverId(message.getReceiver().getId());
        response.setContent(message.getContent());
        response.setTimestamp(message.getTimestamp());
        return response;
    }


}