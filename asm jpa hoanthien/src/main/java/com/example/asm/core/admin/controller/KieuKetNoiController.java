package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.response.AdminKieuKetNoiResponse;
import com.example.asm.core.admin.service.KieuKetNoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/kieuketnoi")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class KieuKetNoiController{
    @Autowired
    private KieuKetNoiService kieuKetNoiService;
    @GetMapping
    public List<AdminKieuKetNoiResponse> getAll(){
        return kieuKetNoiService.getAll();
    }
}
