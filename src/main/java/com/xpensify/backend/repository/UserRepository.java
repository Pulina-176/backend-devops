package com.xpensify.backend.repository;

import com.xpensify.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Mapping

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    List<User> findById(long id);
}
