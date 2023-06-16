package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.response.AdminBanPhimThongKeResponse;
import com.example.asm.core.admin.model.response.AdminHoaDonChiTietResponse;
import com.example.asm.core.admin.model.response.AdminSanPhamDaMuaResponse;
import com.example.asm.core.admin.model.response.AdminThongKeBanPhimTonResponse;
import com.example.asm.core.admin.repository.AdminGioHangChiTietRepository;
import com.example.asm.core.admin.service.GioHangChiTietService;
import com.example.asm.entity.GioHangChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/giohangchitiet")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class GioHangChiTietController {
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private AdminGioHangChiTietRepository gioHangChiTietRepository;

    @GetMapping("/themvaogio/{idkh}/{idbanphim}")
    public GioHangChiTiet themSanPhamVaoGio(@PathVariable("idkh") Long idKh, @PathVariable("idbanphim") Long idBanPhim) {
        return gioHangChiTietService.themSanPhamVaoGioHang(idBanPhim, idKh);
    }

    @GetMapping("/xoa/{idkh}/{idbanphim}")
    public void xoaSanPhamKhoiGio(@PathVariable("idkh") Long idKh, @PathVariable("idbanphim") Long idBanPhim) {
        gioHangChiTietService.xoaSanPhamKhoiGio(idKh, idBanPhim);
    }

    @GetMapping("/{idkh}")
    public List<GioHangChiTiet> findGioHangByKhachHang(@PathVariable(name = "idkh") Long idKh) {
        return gioHangChiTietService.findGioHangByKhachHang(idKh);
    }

    @GetMapping("/tongtien/{idkh}")
    public String findTongTienByIdKhachHang(@PathVariable(name = "idkh") Long idKh) {
        String tongTien[] = gioHangChiTietService.tongTienTrongGio(idKh).toString().split(Pattern.quote("."));
        return tongTien[0];
    }

    @GetMapping("/damua/{idkh}")
    public List<AdminSanPhamDaMuaResponse> daMuaTrongGio(@PathVariable("idkh") Long idkh) {
        return gioHangChiTietService.listSanPhamDaMua(idkh);
    }

    @GetMapping("/damua/{idkh}/{trangthai}")
    public List<AdminSanPhamDaMuaResponse> daMuaTrongGioKemTrangThai(@PathVariable("idkh") Long idkh,
                                                                     @PathVariable("trangthai") Integer trangThai) {
        return gioHangChiTietService.listSanPhamDaMuaKemTrangThai(idkh, trangThai);
    }

    @GetMapping("/hoadonchitiet/{idhoadon}")
    public List<AdminHoaDonChiTietResponse> viewHoaDonChiTietById(@PathVariable("idhoadon") Long idHoaDon) {
        return gioHangChiTietService.listHoaDonChiTietById(idHoaDon);
    }

    @GetMapping("/updategiohang/{idgiohang}/{idbanphim}/{soluong}")
    public GioHangChiTiet updateGioHangChiTiet(
            @PathVariable("idgiohang") Long idGioHang,
            @PathVariable("idbanphim") Long idBanPhim,
            @PathVariable("soluong") Integer soLuong
    ) {
        return gioHangChiTietService.updateGioHangChiTiet(idGioHang, idBanPhim, soLuong);
    }
    @GetMapping("/topsanphambanchay")
    public List<AdminBanPhimThongKeResponse> viewBanPhimThongKeBanChay(){
        return gioHangChiTietService.dsBanPhimBanChay();
    }
    @GetMapping("/topspbanchay")
    public List<AdminBanPhimThongKeResponse> viewThongKeBanTheoThoiGian(
            @RequestParam(value = "ngay",required = false)Integer ngay,
            @RequestParam(value = "tuan",required = false)Integer tuan,
            @RequestParam(value = "thang",required = false)Integer thang){
        return gioHangChiTietService.dsBanPhimBanChayTheoThoiGian(ngay,tuan,thang);
    }

    @GetMapping("/topsanphamton")
    public List<AdminThongKeBanPhimTonResponse> viewThongKeTon(){
        return gioHangChiTietService.dsBanPhimTon();
    }

    @GetMapping("/topspton")
    public List<AdminThongKeBanPhimTonResponse> viewThongKeSpTonTheoThoiGian(
            @RequestParam(value = "ngay",required = false)Integer ngay,
            @RequestParam(value = "tuan",required = false)Integer tuan,
            @RequestParam(value = "thang",required = false)Integer thang){
        return gioHangChiTietService.dsBanPhimTonTheoThoiGian(ngay,tuan,thang);
    }
}
