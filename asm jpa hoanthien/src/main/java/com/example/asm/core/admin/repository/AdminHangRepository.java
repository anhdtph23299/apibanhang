package com.example.asm.core.admin.repository;

import com.example.asm.core.admin.model.response.AdminHangResponse;
import com.example.asm.repository.HangRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminHangRepository extends HangRepository {
    @Query("select h from Hang h")
    List<AdminHangResponse> getAll();
}
