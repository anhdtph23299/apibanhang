package com.example.asm.entity;

import com.example.asm.entity.base.PrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
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
import java.text.DecimalFormat;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "banphim")
public class BanPhim extends PrimaryKey {
    @Column(name = "tenbanphim")
    private String tenBanPhim;
    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "dennen")
    private Boolean denNen;
    @Column(name = "mota")
    private String mota;
    private byte[] images;
    @ManyToOne
    @JoinColumn(name = "mahang")
    @JsonIgnoreProperties("banPhimList")
    private Hang hang;

    @ManyToOne
    @JoinColumn(name = "makieu")
    @JsonIgnoreProperties("banPhimList")

    private KieuKetNoi kieuKetNoi;
    @ManyToOne
    @JoinColumn(name = "maloai")
    @JsonIgnoreProperties("banPhimList")
    private LoaiBanPhim loaiBanPhim;

    @ManyToOne
    @JoinColumn(name = "mamau")
    @JsonIgnoreProperties("banPhimList")
    private MauSac mauSac;
    public String getDonGia1() {
        donGia = donGia.setScale(2, BigDecimal.ROUND_DOWN);

        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(2);

        df.setMinimumFractionDigits(0);

        df.setGroupingUsed(false);

        String result = df.format(donGia);
        return result;
    }


}
