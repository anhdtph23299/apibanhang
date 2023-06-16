package com.example.asm.core.admin.model.response;

import com.example.asm.entity.GioHang;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;


@Projection(types = {GioHang.class})
public interface AdminHoaDonResponse {

    @Value("#{target.id}")
    Integer getId();

    @Value("#{target.tenNguoiNhan}")
    String getTenNguoiNhan();

    @Value("#{target.sdt}")
    String getSdt();

    @Value("#{target.ngayTao}")
    Date getNgayTao();

    @Value("#{target.ngayThanhToan}")
    Date getNgayThanhToan();

    @Value("#{target.diaChi}")
    String getDiaChi();

    @Value("#{target.trangThai}")
    Integer getTrangThai();
    @Value("#{target.tt}")
    String getTinhTrang();

}
