package com.example.asm.core.admin.repository;

import com.example.asm.core.admin.model.response.AdminBanPhimThongKeResponse;
import com.example.asm.core.admin.model.response.AdminSanPhamDaMuaResponse;
import com.example.asm.core.admin.model.response.AdminThongKeBanPhimTonResponse;
import com.example.asm.entity.BanPhim;
import com.example.asm.entity.GioHang;
import com.example.asm.entity.GioHangChiTiet;
import com.example.asm.repository.GioHangChiTietRepository;
import com.example.asm.repository.GioHangRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AdminGioHangChiTietRepository extends GioHangChiTietRepository {
    @Query("SELECT gh FROM GioHang gh JOIN GioHangChiTiet ghct ON ghct.gioHang.id = gh.id JOIN BanPhim b" +
            " ON b.id = ghct.banPhim.id \n" +
            "WHERE b.id = :idBanPhim AND gh.khachHang.id = :idKhachHang and gh.trangThai=0")
    GioHang timKiembanPhimByIdBanPhimAndIdKhachHang(@Param("idBanPhim") Long idBanPhim, @Param("idKhachHang") Long idKhachHang);

    @Query(value = """
            SELECT SUM(b.DonGia*ghct.SoLuong) FROM dbo.GioHang gh JOIN dbo.GioHangChiTiet ghct ON ghct.IdGioHang = gh.id JOIN dbo.BanPhim b ON b.id = ghct.IdBanPhim
             JOIN dbo.KhachHang kh ON kh.id = gh.IdKH WHERE kh.id =:idkh and gh.trangThai = 0
            """, nativeQuery = true)
    BigDecimal tinhTongGioHangByKhachHang(@Param("idkh") Long idKh);

    @Query(value = """
                SELECT ghct FROM GioHang gh JOIN GioHangChiTiet ghct ON ghct.gioHang.id = gh.id
                 JOIN KhachHang kh ON kh.id = gh.khachHang.id WHERE kh.id = :idkh and gh.trangThai=0
            """)
    List<GioHangChiTiet> timKiemGioHangByKhachHangId(@Param("idkh") Long idKh);

    @Query("select ghct from GioHangChiTiet ghct join GioHang gh on ghct.gioHang.id = gh.id " +
            "join KhachHang kh on kh.id = gh.khachHang.id where kh.id =:idKh and gh.trangThai not in(0)")
    List<AdminSanPhamDaMuaResponse> listSanPhamDaMua(@Param("idKh") Long idKh);

    @Query("select ghct from GioHangChiTiet ghct join GioHang gh on ghct.gioHang.id = gh.id " +
            "join KhachHang kh on kh.id = gh.khachHang.id where kh.id =:idKh and gh.trangThai =:trangthai")
    List<AdminSanPhamDaMuaResponse> listSanPhamDaMuaKemTrangThai(@Param("idKh") Long idKh,
                                                                 @Param("trangthai") Integer trangThai);
    @Query("select bp.tenBanPhim as tenBanPhim,count(ghct.banPhim.id) as soLuong from BanPhim bp join GioHangChiTiet ghct on " +
            "ghct.banPhim.id=bp.id join GioHang gh on ghct.gioHang.id = gh.id where gh.trangThai  in (2,3) " +
            "group by bp.tenBanPhim order by soLuong desc Limit 10")
    List<AdminBanPhimThongKeResponse> dsBanPhimBanChay();
    @Query("select bp.tenBanPhim as tenBanPhim,count(ghct.banPhim.id) as soLuong from BanPhim bp join GioHangChiTiet ghct on " +
            "ghct.banPhim.id=bp.id join GioHang gh on ghct.gioHang.id = gh.id where day(gh.ngayThanhToan)=:ngay and month(gh.ngayThanhToan)=:thang and year(gh.ngayThanhToan)=:nam and gh.trangThai in (2,3) " +
            "group by bp.tenBanPhim order by soLuong desc Limit 10")
    List<AdminBanPhimThongKeResponse> dsBanPhimBanChayTheoNgay(@Param("ngay") Integer ngay,@Param("thang") Integer thang, @Param("nam") Integer nam);
    @Query("select bp.tenBanPhim as tenBanPhim,count(ghct.banPhim.id) as soLuong from BanPhim bp join GioHangChiTiet ghct on " +
            "ghct.banPhim.id=bp.id join GioHang gh on ghct.gioHang.id = gh.id where week(gh.ngayThanhToan)=:tuan and year(gh.ngayThanhToan)=:nam and gh.trangThai in (2,3) " +
            "group by bp.tenBanPhim order by soLuong desc Limit 10")
    List<AdminBanPhimThongKeResponse> dsBanPhimBanChayTheoTuan(@Param("tuan") Integer tuan, @Param("nam") Integer nam);
    @Query("select bp.tenBanPhim as tenBanPhim,count(ghct.banPhim.id) as soLuong from BanPhim bp join GioHangChiTiet ghct on " +
            "ghct.banPhim.id=bp.id join GioHang gh on ghct.gioHang.id = gh.id where month(gh.ngayThanhToan)=:thang and year(gh.ngayThanhToan)=:nam and gh.trangThai in (2,3) " +
            "group by bp.tenBanPhim order by soLuong desc Limit 10")
    List<AdminBanPhimThongKeResponse> dsBanPhimBanChayTheoThang(@Param("thang") Integer thang, @Param("nam") Integer nam);

    @Query("SELECT  bp.id as id,bp.tenBanPhim as tenBanPhim,bp.soLuong as soLuong FROM BanPhim bp WHERE bp.id NOT IN " +
            "(SELECT ghct.banPhim.id FROM GioHangChiTiet ghct JOIN GioHang gh ON ghct.gioHang.id = gh.id" +
            " WHERE gh.trangThai IN (2,3) ) order by bp.id desc")
    List<AdminThongKeBanPhimTonResponse> dsBanPhimTon();

    @Query("SELECT  bp.id as id,bp.tenBanPhim as tenBanPhim,bp.soLuong as soLuong FROM BanPhim bp WHERE bp.id NOT IN " +
            "(SELECT ghct.banPhim.id FROM GioHangChiTiet ghct JOIN GioHang gh ON ghct.gioHang.id = gh.id" +
            " WHERE day(gh.ngayThanhToan)=:ngay and month(gh.ngayThanhToan)=:thang and year(gh.ngayThanhToan)=:nam" +
            " and gh.trangThai IN (2,3) ) order by bp.id desc")
    List<AdminThongKeBanPhimTonResponse> dsBanPhimTonTheoNgay(@Param("ngay") Integer ngay,@Param("thang") Integer thang, @Param("nam") Integer nam);
    @Query("SELECT  bp.id as id,bp.tenBanPhim as tenBanPhim,bp.soLuong as soLuong FROM BanPhim bp WHERE bp.id NOT IN " +
            "(SELECT ghct.banPhim.id FROM GioHangChiTiet ghct JOIN GioHang gh ON ghct.gioHang.id = gh.id" +
            " WHERE week(gh.ngayThanhToan)=:tuan and year(gh.ngayThanhToan)=:nam" +
            " and gh.trangThai IN (2,3) ) order by bp.id desc")
    List<AdminThongKeBanPhimTonResponse> dsBanPhimTonTheoTuan(@Param("tuan") Integer tuan, @Param("nam") Integer nam);
    @Query("SELECT  bp.id as id,bp.tenBanPhim as tenBanPhim,bp.soLuong as soLuong FROM BanPhim bp WHERE bp.id NOT IN " +
            "(SELECT ghct.banPhim.id FROM GioHangChiTiet ghct JOIN GioHang gh ON ghct.gioHang.id = gh.id" +
            " WHERE month(gh.ngayThanhToan)=:thang and year(gh.ngayThanhToan)=:nam and" +
            " gh.trangThai IN (2,3) ) order by bp.id desc")
    List<AdminThongKeBanPhimTonResponse> dsBanPhimTonTheoThang(@Param("thang") Integer thang, @Param("nam") Integer nam);
}
