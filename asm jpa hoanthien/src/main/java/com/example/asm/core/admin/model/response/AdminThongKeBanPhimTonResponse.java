package com.example.asm.core.admin.model.response;

import com.example.asm.entity.BanPhim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {BanPhim.class})
public interface AdminThongKeBanPhimTonResponse {

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.tenBanPhim}")
    String getTenBanPhim();

    @Value("#{target.soLuong}")
    Integer getSoLuong();
}
