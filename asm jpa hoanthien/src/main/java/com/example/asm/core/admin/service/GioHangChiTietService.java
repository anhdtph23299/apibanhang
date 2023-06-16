package com.example.asm.core.admin.service;

import com.example.asm.core.admin.model.response.AdminBanPhimThongKeResponse;
import com.example.asm.core.admin.model.response.AdminHoaDonChiTietResponse;
import com.example.asm.core.admin.model.response.AdminSanPhamDaMuaResponse;
import com.example.asm.core.admin.model.response.AdminThongKeBanPhimTonResponse;
import com.example.asm.entity.GioHangChiTiet;

import java.math.BigDecimal;
import java.util.List;

public interface GioHangChiTietService {

    GioHangChiTiet themSanPhamVaoGioHang(Long idBanPhim,Long idKh );

    void xoaSanPhamKhoiGio(Long idKh, Long idBanPhim);

    BigDecimal tongTienTrongGio(Long idKh);

    List<GioHangChiTiet> findGioHangByKhachHang(Long idKh);

    List<AdminSanPhamDaMuaResponse> listSanPhamDaMua(Long idKh);
    List<AdminSanPhamDaMuaResponse> listSanPhamDaMuaKemTrangThai(Long idKh,Integer trangThai);

    List<AdminHoaDonChiTietResponse> listHoaDonChiTietById(Long idHoaDon);

    GioHangChiTiet updateGioHangChiTiet(Long idGioHang,Long idBanPhim,Integer soLuong);

    List<AdminBanPhimThongKeResponse> dsBanPhimBanChay();

    List<AdminBanPhimThongKeResponse> dsBanPhimBanChayTheoThoiGian(Integer ngay,Integer tuan,Integer thang);


    List<AdminThongKeBanPhimTonResponse> dsBanPhimTon();

    List<AdminThongKeBanPhimTonResponse> dsBanPhimTonTheoThoiGian(Integer ngay,Integer tuan,Integer thang);

}
