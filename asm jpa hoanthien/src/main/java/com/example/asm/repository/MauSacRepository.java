package com.example.asm.repository;

import com.example.asm.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MauSacRepository extends JpaRepository<MauSac,Long> {

}
