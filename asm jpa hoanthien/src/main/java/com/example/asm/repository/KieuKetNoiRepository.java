package com.example.asm.repository;

import com.example.asm.entity.KieuKetNoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface KieuKetNoiRepository extends JpaRepository<KieuKetNoi,Long> {

}
