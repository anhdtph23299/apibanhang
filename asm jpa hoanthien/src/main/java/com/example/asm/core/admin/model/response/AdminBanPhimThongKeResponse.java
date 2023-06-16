package com.example.asm.core.admin.model.response;

import com.example.asm.entity.BanPhim;
import com.example.asm.entity.GioHangChiTiet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

public interface AdminBanPhimThongKeResponse {

    String getTenBanPhim();

    Long getSoLuong();

}
