package com.example.asm.jwtsecurity.repositories;

import com.example.asm.jwtsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("abc")
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
}
