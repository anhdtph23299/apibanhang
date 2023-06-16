package com.example.asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "giohangchitiet")
public class GioHangChiTiet {

    @EmbeddedId
    @JsonIgnore
    private GioHangChiTietId gioHangChiTietId;
    @ManyToOne
    @JoinColumn(name = "idgiohang",insertable = false,updatable = false)
    @JsonIgnoreProperties("gioHangChiTietList")
    private GioHang gioHang;
    @ManyToOne
    @JoinColumn(name = "idbanphim",insertable = false,updatable = false)
    @JsonIgnoreProperties("gioHangChiTietList")
    private BanPhim banPhim;
    @Column(name = "soluong")
    private Integer soLuong;
    @Column(name = "dongia")
    private BigDecimal donGia;

    public String getTongTien(){
        Double gia = Double.valueOf(banPhim.getDonGia1())*soLuong;
        return gia.toString();
    }


}
