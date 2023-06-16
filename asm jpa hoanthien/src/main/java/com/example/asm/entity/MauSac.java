package com.example.asm.entity;

import com.example.asm.entity.base.PrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "mausac")
public class MauSac extends PrimaryKey {
    @Column(name = "tenmau")
    private String tenMau;
    @OneToMany(mappedBy = "mauSac")
    @JsonIgnoreProperties("mauSac")
    private List<BanPhim> banPhimList;
}
