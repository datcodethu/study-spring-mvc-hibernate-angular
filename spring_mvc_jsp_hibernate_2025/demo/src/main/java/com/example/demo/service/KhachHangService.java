package com.example.demo.service;

import com.example.demo.dto.KhachHangDto;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository ;

    public List<KhachHangDto> getAllClient () {
        return khachHangRepository.findAll()
                .stream()
                .map(kh -> new KhachHangDto(kh.getId(), kh.getName(), kh.getSdt() , kh.getMaKhachHang() , kh.getTrangThai()))
                .toList();
    }

    public Optional<KhachHangDto> getClient (Long id) {
        return khachHangRepository.findById(id)
                .map(kh -> new KhachHangDto(kh.getId(), kh.getName(), kh.getSdt() , kh.getMaKhachHang() , kh.getTrangThai())) ;

    }

    public KhachHang saveClient (KhachHangDto khachHangDto) {

        return khachHangRepository.save(new KhachHang (
                khachHangDto.getId(),
                khachHangDto.getName(),
                khachHangDto.getSdt(),
                khachHangDto.getMaKhachHang(),
                khachHangDto.getTrangThai()));
    }

    public void deleteClient(Long id ) {
        khachHangRepository.deleteById(id);
    }

}
