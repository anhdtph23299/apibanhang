package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.model.response.AdminHoaDonResponse;
import com.example.asm.core.admin.repository.AdminBanPhimRepository;
import com.example.asm.core.admin.repository.AdminGioHangChiTietRepository;
import com.example.asm.core.admin.repository.AdminGioHangRepository;
import com.example.asm.core.admin.service.GioHangService;
import com.example.asm.entity.BanPhim;
import com.example.asm.entity.GioHang;
import com.example.asm.entity.GioHangChiTiet;
import com.example.asm.repository.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    AdminGioHangRepository gioHangRepository;

    @Autowired
    AdminBanPhimRepository banPhimRepository;

    @Override
    public BigDecimal tinhTongTienTrongGio(Long idKh) {
        return null;
    }

    @Override
    public BanPhim suaSanPhamTrongGio(Long idBanPhim, Long idKhachHang, Integer soLuong) {
        return null;
    }


    @Override
    public Long soLuongTrongGio(Long idKh) {
        return gioHangRepository.timSoLuongTrongGio(idKh);
    }

    @Override
    public List<AdminHoaDonResponse> toanBoGioHang() {
        return gioHangRepository.hoaDon();
    }

    @Override
    public Integer tinhTrangHoaDon(Long idHoaDon) {
        return gioHangRepository.tinhTrangHoaDon(idHoaDon);
    }

    @Override
    public GioHang capNhatTrangThai(Long idGioHang, Integer trangThai) {
        GioHang gioHang = gioHangRepository.findById(idGioHang).get();
        gioHang.setTrangThai(trangThai);
        if (gioHang.getTrangThai()==1){
            gioHang.setNgayTao(new Date(new java.util.Date().getTime()));
        }
        if (trangThai==2){
            List<GioHangChiTiet> gioHangChiTietList = gioHangRepository.timGioHangChiTietByIdGioHang(idGioHang);
            for (GioHangChiTiet x:gioHangChiTietList
                 ) {
                BanPhim banPhim = banPhimRepository.findById(x.getBanPhim().getId()).get();
                x.setDonGia(banPhim.getDonGia());

                banPhim.setSoLuong(banPhim.getSoLuong()-x.getSoLuong());
                banPhimRepository.save(banPhim);
            }
            gioHang.setNgayThanhToan(new Date(new java.util.Date().getTime()));
        }
        return gioHangRepository.save(gioHang);
    }
}
