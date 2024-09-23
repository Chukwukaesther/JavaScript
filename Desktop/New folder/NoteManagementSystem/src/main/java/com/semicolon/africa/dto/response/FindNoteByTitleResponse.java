package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class FindNoteByTitleResponse {
    private Long noteId;
    private String title;
    private String content;
    private LocalDateTime dateCreated;

}
