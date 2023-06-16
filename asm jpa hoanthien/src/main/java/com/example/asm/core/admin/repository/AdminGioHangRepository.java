package com.example.asm.core.admin.repository;

import com.example.asm.core.admin.model.response.AdminHoaDonChiTietResponse;
import com.example.asm.core.admin.model.response.AdminHoaDonResponse;
import com.example.asm.entity.GioHang;
import com.example.asm.entity.GioHangChiTiet;
import com.example.asm.repository.GioHangRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminGioHangRepository extends GioHangRepository {

    @Query("select ghct from GioHangChiTiet ghct where ghct.gioHang.id =:idgh")
    List<GioHangChiTiet> timGioHangChiTietByIdGioHang(@Param("idgh") Long idGioHang);
    @Query("select gh from GioHang gh where gh.khachHang.id =:idKh and gh.trangThai =0")
    GioHang timGioHangByMaKh(Long idKh);

    @Query("select gh from GioHang gh where gh.trangThai not in(0)")
    List<AdminHoaDonResponse> hoaDon();
    @Query("select ghct from GioHangChiTiet ghct where ghct.gioHang.id =:idhoadon")
    List<AdminHoaDonChiTietResponse> hoaDonChiTiet(@Param("idhoadon") Long idHoaDon);

    @Query("select gh.trangThai from GioHang gh where gh.id=:idhoadon")
    Integer tinhTrangHoaDon(@Param("idhoadon")Long idHoaDon);

    @Query("select gh from GioHang gh where gh.trangThai=0 and gh.khachHang.id=:idKhachHang")
    GioHang timGiohangByMaKhachHang(@Param("idKhachHang")Long idKhachHang);
}
