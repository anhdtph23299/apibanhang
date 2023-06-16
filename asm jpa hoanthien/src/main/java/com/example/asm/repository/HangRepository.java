package com.example.asm.repository;

import com.example.asm.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangRepository extends JpaRepository<Hang,Long> {
}
