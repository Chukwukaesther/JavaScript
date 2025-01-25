package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Message;
import com.semicolon.farm_Links.data.model.User;
import com.semicolon.farm_Links.data.repository.MessageRepository;
import com.semicolon.farm_Links.dto.request.MessageRequest;
import com.semicolon.farm_Links.dto.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.semicolon.farm_Links.controller.MessageController.getMessageResponse;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {


    private final MessageRepository messageRepository;
    private final UserService userService;


    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest) {
        User sender = userService.findById(messageRequest.getSenderId())
                .orElseThrow(() -> new IllegalArgumentException("Sender not found"));
        User receiver = userService.findById(messageRequest.getReceiverId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(messageRequest.getContent());
        message.setTimestamp(LocalDateTime.now());

        Message savedMessage = messageRepository.save(message);
        return convertToMessageResponse(savedMessage);
    }


    @Override
    public List<Message> getConversation() {
        return messageRepository.findAll();
    }

    private MessageResponse convertToMessageResponse(Message message) {
        return getMessageResponse(message);
    }
}
