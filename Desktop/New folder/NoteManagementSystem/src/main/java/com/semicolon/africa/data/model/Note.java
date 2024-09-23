package com.semicolon.africa.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class Note {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateCreated;
    @ManyToOne
    private User owner;






}
