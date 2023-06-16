package com.example.asm.core.admin.repository;

import com.example.asm.core.admin.model.response.AdminKieuKetNoiResponse;
import com.example.asm.repository.KieuKetNoiRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AdminKieuKetNoiRepository extends KieuKetNoiRepository {
    @Query("select k from KieuKetNoi k")
    List<AdminKieuKetNoiResponse> getAll();
}
