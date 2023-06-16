package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.model.response.AdminKieuKetNoiResponse;
import com.example.asm.core.admin.repository.AdminKieuKetNoiRepository;
import com.example.asm.entity.KieuKetNoi;
import com.example.asm.repository.KieuKetNoiRepository;
import com.example.asm.core.admin.service.KieuKetNoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KieuKetNoiServiceImpl implements KieuKetNoiService {
    @Autowired
    private AdminKieuKetNoiRepository kieuKetNoiRepository;
    @Override
    public List<AdminKieuKetNoiResponse> getAll() {
        return kieuKetNoiRepository.getAll();
    }
}
