package com.example.asm.core.admin.model.response;

import com.example.asm.entity.GioHangChiTiet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(types = {GioHangChiTiet.class})
public interface AdminHoaDonChiTietResponse {


    @Value("#{target.banPhim.images}")
    byte[] getImages();

    @Value("#{target.banPhim.tenBanPhim}")
    String getTenBanPhim();

    @Value("#{target.soLuong}")
    Integer getSoLuong();

    @Value("#{target.banPhim.donGia}")
    BigDecimal getDonGia();
}
