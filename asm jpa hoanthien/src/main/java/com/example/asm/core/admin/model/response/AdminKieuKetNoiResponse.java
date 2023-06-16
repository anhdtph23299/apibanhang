package com.example.asm.core.admin.model.response;

import com.example.asm.entity.KieuKetNoi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {KieuKetNoi.class})
public interface AdminKieuKetNoiResponse {
    @Value("#{target.id}")
    Long getId();

    @Value("#{target.tenKieu}")
    String getTenKieu();

}
