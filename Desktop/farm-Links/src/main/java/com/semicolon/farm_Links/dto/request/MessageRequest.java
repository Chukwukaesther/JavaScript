package com.semicolon.farm_Links.dto.request;


import lombok.Data;

@Data
public class MessageRequest {
    private Long senderId;
    private Long receiverId;
    private String content;
}
