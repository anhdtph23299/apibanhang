package com.example.asm.core.admin.service;

import com.example.asm.core.admin.model.response.AdminHoaDonResponse;
import com.example.asm.entity.BanPhim;
import com.example.asm.entity.GioHang;
import com.example.asm.entity.KhachHang;

import java.math.BigDecimal;
import java.util.List;

public interface GioHangService {

    BigDecimal tinhTongTienTrongGio(Long idKh);

    BanPhim suaSanPhamTrongGio(Long idBanPhim, Long idKhachHang,Integer soLuong);

    Long soLuongTrongGio(Long idKh);

    List<AdminHoaDonResponse> toanBoGioHang();
    Integer tinhTrangHoaDon(Long idHoaDon);

    GioHang capNhatTrangThai(Long idGioHang,Integer trangThai);
}
