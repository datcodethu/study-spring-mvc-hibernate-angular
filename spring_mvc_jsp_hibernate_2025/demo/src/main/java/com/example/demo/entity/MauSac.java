package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma", length = 50, nullable = false, unique = true)
    private String ma;

    @Column(name = "Ten", length = 255, nullable = false)
    private String ten;

    @Column(name = "TrangThai", nullable = false)
    private Byte trangThai;  // Dùng Byte vì TINYINT trong MySQL

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Byte getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Byte trangThai) {
        this.trangThai = trangThai;
    }
}

