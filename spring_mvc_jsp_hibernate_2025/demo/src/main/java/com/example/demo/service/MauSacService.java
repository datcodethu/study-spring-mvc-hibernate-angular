package com.example.demo.service;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }


    public Optional<MauSac> getMauSacById(Integer id) {
        return mauSacRepository.findById(id);
    }


    public MauSac createMauSac(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }


    public MauSac updateMauSac(Integer id, MauSac mauSac) {
        return mauSacRepository.findById(id)
                .map(existingMauSac -> {
                    existingMauSac.setMa(mauSac.getMa());
                    existingMauSac.setTen(mauSac.getTen());
                    existingMauSac.setTrangThai(mauSac.getTrangThai());
                    return mauSacRepository.save(existingMauSac);
                }).orElseThrow(() -> new RuntimeException("Màu sắc không tồn tại"));
    }

    public void deleteMauSac(Integer id) {
        mauSacRepository.deleteById(id);
    }
}
