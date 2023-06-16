package com.example.asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTietId implements Serializable {

    @Column(name = "idgiohang")
    private Long idGioHang;
    @Column(name = "idbanphim")
    private Long idBanPhim;
}
