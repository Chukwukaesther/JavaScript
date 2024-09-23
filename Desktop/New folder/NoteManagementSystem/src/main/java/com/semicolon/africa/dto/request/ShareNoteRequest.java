package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShareNoteRequest {
    private String recipientUsername;
    private String senderUsername;
    private String noteTitle;
}
