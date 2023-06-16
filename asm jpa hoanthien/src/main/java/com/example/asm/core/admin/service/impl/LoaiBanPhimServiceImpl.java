package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.model.response.AdminLoaiBanPhimResponse;
import com.example.asm.core.admin.repository.AdminLoaiBanPhimRepository;
import com.example.asm.entity.LoaiBanPhim;
import com.example.asm.repository.LoaiBanPhimRepository;
import com.example.asm.core.admin.service.LoaiBanPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiBanPhimServiceImpl implements LoaiBanPhimService {
    @Autowired
    private AdminLoaiBanPhimRepository loaiBanPhimRepository;
    @Override
    public List<AdminLoaiBanPhimResponse> getAll() {
        return loaiBanPhimRepository.getAll();
    }
}
