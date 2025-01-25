package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Message;
import com.semicolon.farm_Links.dto.request.MessageRequest;
import com.semicolon.farm_Links.dto.response.MessageResponse;

import java.util.List;

public interface MessageService {
    MessageResponse sendMessage(MessageRequest messageRequest);
    List<Message> getConversation();
}
