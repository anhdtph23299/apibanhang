package com.example.asm.repository;

import com.example.asm.entity.LoaiBanPhim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LoaiBanPhimRepository extends JpaRepository<LoaiBanPhim,Long> {
}
