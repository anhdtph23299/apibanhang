package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.response.AdminHoaDonResponse;
import com.example.asm.core.admin.repository.AdminGioHangRepository;
import com.example.asm.core.admin.service.GioHangService;
import com.example.asm.entity.GioHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/giohang")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class GioHangController {

    @Autowired
    GioHangService gioHangService;
    @Autowired
    AdminGioHangRepository adminGioHangRepository;

    @GetMapping("/{idkh}")
    public GioHang viewGioHang(@PathVariable("idkh") Long idKh) {
        return adminGioHangRepository.timGioHangByMaKh(idKh);
    }
//    @GetMapping("/{idkh}")
//    public GioHang getGioHangByIdKhachHang(@PathVariable("idkh") Long idKh){
//
//    }
    @PostMapping("/dathang")
    public GioHang thanhToan(@RequestBody GioHang gioHang) {
        gioHang.setTrangThai(1);
        gioHang.setNgayTao(new java.sql.Date(new Date().getTime()));
        return adminGioHangRepository.save(gioHang);
    }

    @GetMapping("/giohangdangcho")
    public List<AdminHoaDonResponse> viewHoaDon() {
        return gioHangService.toanBoGioHang();
    }

    @GetMapping("/tinhtrang/{idhoadon}")
    public Integer tinhTrangHoaDon(@PathVariable("idhoadon") Long idHoaDon) {
        return gioHangService.tinhTrangHoaDon(idHoaDon);
    }

    @GetMapping("/capnhattrangthai/{idhoadon}/{trangthai}")
    public GioHang capNhatTrangThai(@PathVariable("idhoadon") Long idHoaDon, @PathVariable("trangthai") Integer trangThai) {
        return gioHangService.capNhatTrangThai(idHoaDon,trangThai);
    }
}
