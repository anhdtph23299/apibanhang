package com.example.asm.core.admin.repository;

import com.example.asm.entity.KhachHang;
import com.example.asm.repository.GioHangRepository;
import com.example.asm.repository.KhachHangRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminKhachHangRepository extends KhachHangRepository {

    KhachHang findKhachHangByEmail(String email);

    KhachHang findKhachHangByEmailAndMatKhau(String email,String matKhau);

}
