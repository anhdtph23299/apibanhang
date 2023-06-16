package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.repository.AdminKhachHangRepository;
import com.example.asm.core.admin.service.KhachHangService;
import com.example.asm.entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    AdminKhachHangRepository khachHangRepository;
    @Override
    public KhachHang dangKyTaiKhoan(KhachHang khachHang) {
        khachHang.setTrangThai(0);
        return khachHangRepository.save(khachHang);
    }

    @Override
    public Boolean isNotEmail(String email) {
       try {
           if (khachHangRepository.findKhachHangByEmail(email)==null){
               return true;
           }
       }catch (Exception e){
           return false;
       }
       return false;
    }

    @Override
    public KhachHang dangNhapTaiKhoan(String taiKhoan, String passwork) {
        return khachHangRepository.findKhachHangByEmailAndMatKhau(taiKhoan,passwork);
    }
}
