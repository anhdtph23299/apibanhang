package com.example.asm.entity;

import com.example.asm.entity.base.PrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loaibanphim")
public class LoaiBanPhim extends PrimaryKey {

    @Column(name = "tenloai")
    private String tenLoai;
    @OneToMany(mappedBy = "loaiBanPhim")
    @JsonIgnoreProperties("loaiBanPhim")
    private List<BanPhim> banPhimList;
}
