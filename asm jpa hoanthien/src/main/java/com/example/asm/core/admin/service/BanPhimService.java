package com.example.asm.core.admin.service;

import com.example.asm.core.admin.model.request.SearchThuocTinhCustomModel;
import com.example.asm.entity.BanPhim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface BanPhimService {

    BanPhim saveOrUpdate(BanPhim banPhim);
    void delete(BanPhim banPhim);

    Page<BanPhim> findByThuocTinh(SearchThuocTinhCustomModel model, Pageable pageable);
    Page<BanPhim> getAll(Pageable pageable);
    BanPhim findByMaSanPham(Long maSanPham);

    List<BanPhim> findTop3ByTenSanPham(String tenSanPham);

    List<BanPhim> chiaTrang(Long soTrang);

    Long tongSoTrang();
    Integer tongSoTrangCoPhanTu(int soPhanTu) ;

    Integer getSizeByTen(String ten);
    Integer getSizeKhoangGia(BigDecimal min,BigDecimal max);

    List<BanPhim> findBanPhimByKhoang(BigDecimal min, BigDecimal max);

    List<BanPhim> dsBanPhimBanChay();

    List<BanPhim> getAll();



}
