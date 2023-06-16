package com.example.asm.core.admin.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BanPhimCustomModel {

    private Long id;
    private String tenBanPhim;
    private Integer soLuong;
    private BigDecimal donGia;
    private String denNen;
    private String mota;
}
