package com.example.asm.core.admin.repository;

import com.example.asm.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User1,Integer> {
    User1 findByUsername(String username);

    User1 findByUsernameAndPassword(String username, String password);
}
