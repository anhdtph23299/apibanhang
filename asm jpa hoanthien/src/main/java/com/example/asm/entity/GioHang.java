package com.example.asm.entity;

import com.example.asm.entity.base.PrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "giohang")
public class GioHang extends PrimaryKey {

    @ManyToOne
    @JoinColumn(name = "idnv")
    @JsonIgnoreProperties("gioHangList")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "idkh")
    @JsonIgnoreProperties("gioHangList")
    private KhachHang khachHang;
    @Column(name = "ngaytao")
    private Date ngayTao;
    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;
    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "diachi")
    private String diaChi;
    private String sdt;
    @JsonIgnore
    @OneToMany(mappedBy = "gioHang")
    @JsonIgnoreProperties("gioHang")
    private List<GioHangChiTiet> gioHangChiTietList;

    public String getTt() {
        return getTrangThai() == 1 ? "Chờ thanh toán" : getTrangThai() == 2 ? "Thanh toán thành công" :
                getTrangThai() == 3 ? "Đã giao" : getTrangThai() == 0 ? "Ở trong giỏ" : "Huỷ";
    }
}
