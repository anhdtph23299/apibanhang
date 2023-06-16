package com.example.asm.repository;

import com.example.asm.entity.GioHangChiTiet;
import com.example.asm.entity.GioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {

}
