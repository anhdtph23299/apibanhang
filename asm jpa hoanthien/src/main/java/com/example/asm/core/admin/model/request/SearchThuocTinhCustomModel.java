package com.example.asm.core.admin.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SearchThuocTinhCustomModel {

    private String tenBanPhim;
    private BigDecimal min;
    private BigDecimal max;
    private Boolean denNen;
    private String hang;
    private String kieuKetNoi;
    private String loaiBanPhim;
}
