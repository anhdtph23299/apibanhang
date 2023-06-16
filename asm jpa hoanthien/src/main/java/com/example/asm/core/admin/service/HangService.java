package com.example.asm.core.admin.service;

import com.example.asm.core.admin.model.response.AdminHangResponse;
import com.example.asm.entity.Hang;

import java.util.List;

public interface HangService {

    List<AdminHangResponse> getAll();
}
