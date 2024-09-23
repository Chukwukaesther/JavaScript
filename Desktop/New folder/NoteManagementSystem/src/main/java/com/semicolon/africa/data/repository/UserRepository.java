package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String Email);
    User findByUsername(String username);

    boolean existsByUsername(String username);
}

