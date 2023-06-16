package com.example.asm.core.admin.model.response;

import com.example.asm.entity.Hang;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = {Hang.class})
public interface AdminHangResponse {
    @Value("#{target.id}")
    Long getId();

    @Value("#{target.tenHang}")
    String getTenHang();

}
