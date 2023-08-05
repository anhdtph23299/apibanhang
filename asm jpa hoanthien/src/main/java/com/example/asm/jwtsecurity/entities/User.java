package com.springjwt.entities;

import jakarta.persistence.*;
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

}
