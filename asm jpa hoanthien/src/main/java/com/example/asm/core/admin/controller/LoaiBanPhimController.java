package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.response.AdminLoaiBanPhimResponse;
import com.example.asm.core.admin.service.LoaiBanPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/loaibanphim")
public class LoaiBanPhimController {
    @Autowired
    private LoaiBanPhimService hangService;
    @GetMapping
    public List<AdminLoaiBanPhimResponse> getAll(){
        return hangService.getAll();
    }
}
