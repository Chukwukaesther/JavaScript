package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddNoteRequest {
    private String content;
    private String title;
    private String author;
}
