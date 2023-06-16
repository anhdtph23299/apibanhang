package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.model.response.AdminHangResponse;
import com.example.asm.core.admin.repository.AdminHangRepository;
import com.example.asm.entity.Hang;
import com.example.asm.core.admin.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HangServiceImpl implements HangService {
    @Autowired
    private AdminHangRepository hangRepository;
    @Override
    public List<AdminHangResponse> getAll() {
        return hangRepository.getAll();
    }

}
