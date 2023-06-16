package com.example.asm.entity;

import com.example.asm.entity.base.PrimaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "nhanvien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien extends PrimaryKey {

    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "gioitinh")
    private Boolean gioiTinh;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    private String email;
    private String sdt;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "matkhau")
    private String matKhau;
    private Integer role;

    @OneToMany(mappedBy = "nhanVien")
    private List<GioHang> gioHangList;
}
