package com.example.asm.jwtsecurity.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "nhanvien")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sdt")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "matkhaumoi")
    private String password;

    @Column(name = "role1")
    private String role;

}
