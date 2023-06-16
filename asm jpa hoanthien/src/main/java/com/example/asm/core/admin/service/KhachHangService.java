package com.example.asm.core.admin.service;

import com.example.asm.entity.KhachHang;

public interface KhachHangService {

    KhachHang dangKyTaiKhoan(KhachHang khachHang);

    Boolean isNotEmail(String email);

    KhachHang dangNhapTaiKhoan(String taiKhoan,String passwork);
}
