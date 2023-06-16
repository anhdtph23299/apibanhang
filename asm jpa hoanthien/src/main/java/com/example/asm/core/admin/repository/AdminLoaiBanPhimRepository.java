package com.example.asm.core.admin.repository;

import com.example.asm.core.admin.model.response.AdminLoaiBanPhimResponse;
import com.example.asm.repository.LoaiBanPhimRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminLoaiBanPhimRepository extends LoaiBanPhimRepository {

    @Query("select l from LoaiBanPhim l")
    List<AdminLoaiBanPhimResponse> getAll();
}
