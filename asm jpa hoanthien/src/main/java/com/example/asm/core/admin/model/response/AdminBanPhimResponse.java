package com.example.asm.core.admin.model.response;

import com.example.asm.entity.BanPhim;
import com.example.asm.entity.Hang;
import com.example.asm.entity.KieuKetNoi;
import com.example.asm.entity.LoaiBanPhim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(types = {BanPhim.class})
public interface AdminBanPhimResponse {
    @Value("#{target.id}")
    public Long getId();
    @Value("#{target.tenBanPhim}")
    public String getTenBanPhim();
    @Value("#{target.soLuong}")
    public Integer getSoLuong();
    @Value("#{target.donGia}")
    public BigDecimal getDonGia();
    @Value("#{target.denNen}")
    public Boolean getDenNen();
    @Value("#{target.mota}")
    public String getMota();

    @Value("#{target.hang}")
    public Hang getHang();

    @Value("#{target.kieuKetNoi}")
    public KieuKetNoi getKieuKetNoi();

    @Value("#{target.loaiBanPhim}")
    public LoaiBanPhim getLoaiBanPhim() ;

}
