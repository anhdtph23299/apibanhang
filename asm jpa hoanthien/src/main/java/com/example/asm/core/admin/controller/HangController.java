package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.response.AdminHangResponse;
import com.example.asm.entity.Hang;
import com.example.asm.core.admin.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hang")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class HangController {
    @Autowired
    private HangService hangService;
    @GetMapping
    public List<AdminHangResponse> getAll(){
        return hangService.getAll();
    }
}
