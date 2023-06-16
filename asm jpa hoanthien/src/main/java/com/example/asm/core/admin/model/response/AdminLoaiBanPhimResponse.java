package com.example.asm.core.admin.model.response;

import com.example.asm.entity.LoaiBanPhim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {LoaiBanPhim.class})
public interface AdminLoaiBanPhimResponse {
    @Value("#{target.id}")
    Long getId();

    @Value("#{target.tenLoai}")
    String getTenLoai();

}
