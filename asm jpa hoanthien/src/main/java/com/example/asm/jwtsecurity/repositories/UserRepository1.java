package com.example.asm.jwtsecurity.repositories;

import com.example.asm.jwtsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository1 extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
}
