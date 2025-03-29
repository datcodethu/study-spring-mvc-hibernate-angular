package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name = "KhachHang")
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Setter
    @Column ( name = "name")
    private String name ;

    @Setter
    @Column (name = "sdt")
    private String sdt ;

    @Setter
    @Column (name = "ma_khach")
    private String maKhachHang ;

    @Setter
    @Column (name = "trang_thai")
    private String trangThai;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSdt() {
        return sdt;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }
}
