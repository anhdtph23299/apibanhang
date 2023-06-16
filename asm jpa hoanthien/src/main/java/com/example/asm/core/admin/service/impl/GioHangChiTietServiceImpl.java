package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.model.response.AdminBanPhimThongKeResponse;
import com.example.asm.core.admin.model.response.AdminHoaDonChiTietResponse;
import com.example.asm.core.admin.model.response.AdminSanPhamDaMuaResponse;
import com.example.asm.core.admin.model.response.AdminThongKeBanPhimTonResponse;
import com.example.asm.core.admin.repository.AdminBanPhimRepository;
import com.example.asm.core.admin.repository.AdminGioHangChiTietRepository;
import com.example.asm.core.admin.repository.AdminGioHangRepository;
import com.example.asm.core.admin.repository.AdminKhachHangRepository;
import com.example.asm.core.admin.service.GioHangChiTietService;
import com.example.asm.entity.BanPhim;
import com.example.asm.entity.GioHang;
import com.example.asm.entity.GioHangChiTiet;
import com.example.asm.entity.GioHangChiTietId;
import com.example.asm.entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    AdminGioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    AdminGioHangRepository gioHangRepository;
    @Autowired
    AdminBanPhimRepository banPhimRepository;

    @Autowired
    AdminKhachHangRepository khachHangRepository;

    @Override
    public GioHangChiTiet themSanPhamVaoGioHang(Long idBanPhim, Long idKh) {

//        GioHang gioHang = gioHangChiTietRepository.timKiembanPhimByIdBanPhimAndIdKhachHang(idBanPhim,idKh);
        GioHang gioHang = gioHangRepository.timGioHangByMaKh(idKh);
        if (gioHang == null) {
            KhachHang khachHang = khachHangRepository.findById(idKh).get();
            gioHang = new GioHang();
            gioHang.setDiaChi(khachHang.getDiaChi());
            gioHang.setTenNguoiNhan(khachHang.getHoTen());
            gioHang.setSdt(khachHang.getSdt());
            gioHang.setTrangThai(0);
            gioHang.setKhachHang(khachHang);
            gioHang = gioHangRepository.save(gioHang);
//            BanPhim banPhim = banPhimRepository.findById(idBanPhim).get();
            GioHangChiTietId gioHangChiTietId = new GioHangChiTietId(gioHang.getId(), idBanPhim);
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setGioHangChiTietId(gioHangChiTietId);
            gioHangChiTiet.setSoLuong(1);
            return gioHangChiTietRepository.save(gioHangChiTiet);
        } else {
            GioHangChiTietId gioHangChiTietId = new GioHangChiTietId(gioHang.getId(), idBanPhim);
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();

            try {
                gioHangChiTiet = gioHangChiTietRepository.findById(gioHangChiTietId).get();
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
            } catch (Exception e) {
                gioHangChiTiet.setGioHangChiTietId(gioHangChiTietId);
                gioHangChiTiet.setSoLuong(1);
            }
            return gioHangChiTietRepository.save(gioHangChiTiet);
        }
    }

    @Override
    public BigDecimal tongTienTrongGio(Long idKh) {
        return gioHangChiTietRepository.tinhTongGioHangByKhachHang(idKh);
    }

    @Override
    public List<GioHangChiTiet> findGioHangByKhachHang(Long idKh) {
        return gioHangChiTietRepository.timKiemGioHangByKhachHangId(idKh);
    }

    @Override
    public List<AdminSanPhamDaMuaResponse> listSanPhamDaMua(Long idKh) {
        return gioHangChiTietRepository.listSanPhamDaMua(idKh);
    }

    @Override
    public List<AdminSanPhamDaMuaResponse> listSanPhamDaMuaKemTrangThai(Long idKh, Integer trangThai) {
        return gioHangChiTietRepository.listSanPhamDaMuaKemTrangThai(idKh, trangThai);
    }

    @Override
    public List<AdminHoaDonChiTietResponse> listHoaDonChiTietById(Long idHoaDon) {
        return gioHangRepository.hoaDonChiTiet(idHoaDon);
    }

    @Override
    public GioHangChiTiet updateGioHangChiTiet(Long idGioHang, Long idBanPhim, Integer soLuong) {
        GioHangChiTietId gioHangChiTietId = new GioHangChiTietId();
        gioHangChiTietId.setIdBanPhim(idBanPhim);
        gioHangChiTietId.setIdGioHang(idGioHang);
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(gioHangChiTietId).get();
        Integer sl = gioHangChiTiet.getSoLuong() + soLuong;
        if (sl == 0) {
            gioHangChiTietRepository.delete(gioHangChiTiet);
        } else {
            gioHangChiTiet.setSoLuong(sl);
            gioHangChiTietRepository.save(gioHangChiTiet);
        }
        return gioHangChiTiet;
    }

    @Override
    public List<AdminBanPhimThongKeResponse> dsBanPhimBanChay() {
        return gioHangChiTietRepository.dsBanPhimBanChay();
    }

    @Override
    public List<AdminBanPhimThongKeResponse> dsBanPhimBanChayTheoThoiGian(Integer ngay, Integer tuan, Integer thang) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        month++;
        int year = calendar.get(Calendar.YEAR);
        List<AdminBanPhimThongKeResponse> list;
        int nam = date.getYear();
        if (ngay != null) {
            list = gioHangChiTietRepository.dsBanPhimBanChayTheoNgay(ngay, month, year);
        } else if (tuan != null) {
            list = gioHangChiTietRepository.dsBanPhimBanChayTheoTuan(week, year);
        }else{
            list = gioHangChiTietRepository.dsBanPhimBanChayTheoThang(month,year);
        }
        return list;
    }

    @Override
    public List<AdminThongKeBanPhimTonResponse> dsBanPhimTon() {
        return gioHangChiTietRepository.dsBanPhimTon();
    }

    @Override
    public List<AdminThongKeBanPhimTonResponse> dsBanPhimTonTheoThoiGian(Integer ngay, Integer tuan, Integer thang) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        month++;
        int year = calendar.get(Calendar.YEAR);
        List<AdminThongKeBanPhimTonResponse> list;
        if (ngay != null) {
            list = gioHangChiTietRepository.dsBanPhimTonTheoNgay(ngay, month, year);
        } else if (tuan != null) {
            list = gioHangChiTietRepository.dsBanPhimTonTheoTuan(week, year);
        }else{
            list = gioHangChiTietRepository.dsBanPhimTonTheoThang(month,year);
        }
        return list;
    }

    @Override
    public void xoaSanPhamKhoiGio(Long idKh, Long idBanPhim) {
        GioHang gioHang = gioHangRepository.timGioHangByMaKh(idKh);
        GioHangChiTietId gioHangChiTietId = new GioHangChiTietId();
        gioHangChiTietId.setIdGioHang(gioHang.getId());
        gioHangChiTietId.setIdBanPhim(idBanPhim);
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(gioHangChiTietId).get();
        gioHangChiTietRepository.delete(gioHangChiTiet);
    }
}
