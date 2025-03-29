package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class KhachHangDto {

    private Long id;
    private String name ;
    private String sdt ;
    private String maKhachHang ;
    private String trangThai ;

}
