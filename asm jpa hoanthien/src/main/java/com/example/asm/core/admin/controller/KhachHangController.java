package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.request.DangNhapTaiKhoanRequest;
import com.example.asm.core.admin.service.KhachHangService;
import com.example.asm.entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;
    @PostMapping("/dangky")
    public KhachHang dangKyTaiKhoan(@RequestBody KhachHang khachHang){
        if (khachHangService.isNotEmail(khachHang.getEmail())==false){
            return null;
        }
        return khachHangService.dangKyTaiKhoan(khachHang);
    }
    @PostMapping("/dangnhap")
    public KhachHang dangNhapTaiKhoan(@RequestBody DangNhapTaiKhoanRequest taiKhoan){
        System.out.println(taiKhoan);
        KhachHang khachHang = khachHangService.dangNhapTaiKhoan(taiKhoan.getEmail(),taiKhoan.getPassword());
        System.out.println("trick test"+khachHang);
        return khachHang;
    }
}
