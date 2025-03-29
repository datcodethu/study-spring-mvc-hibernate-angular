package com.example.demo.controller.api;

import com.example.demo.dto.KhachHangDto;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class KhachHangApi {

    @Autowired
    private KhachHangService khachHangService ;

    @GetMapping
    public List<KhachHangDto> getAllClient () {
        return khachHangService.getAllClient() ;
    }

    @GetMapping ("/{id}")
    public ResponseEntity<KhachHangDto> getClientById(@PathVariable Long id) {
        return khachHangService.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KhachHang> createClient (@RequestBody KhachHangDto khachHangDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(khachHangService.saveClient(khachHangDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> updateClient(@PathVariable Long id, @RequestBody KhachHangDto khachHangDto) {
        khachHangDto.setId(id);
        return ResponseEntity.ok(khachHangService.saveClient(khachHangDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        khachHangService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
