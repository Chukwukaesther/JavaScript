package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);

    boolean existsByTitle(String title);
}
