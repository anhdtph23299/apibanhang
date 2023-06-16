package com.example.asm.core.admin.model.response;

import com.example.asm.entity.GioHangChiTiet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(types = {GioHangChiTiet.class})
public interface AdminSanPhamDaMuaResponse {

    @Value("#{target.gioHang.tt}")
    String getTrangThai();

    @Value("#{target.banPhim.images}")
    byte[] getImages();
    @Value("#{target.banPhim.loaiBanPhim.tenLoai}")
    String getLoai();

    @Value("#{target.soLuong}")
    Integer getSoLuong();

    @Value("#{target.banPhim.donGia}")
    BigDecimal getDonGia();
}
