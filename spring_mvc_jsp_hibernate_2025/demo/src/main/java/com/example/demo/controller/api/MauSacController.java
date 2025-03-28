package com.example.demo.controller.api;

import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSacService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mausac")
public class MauSacController {

    private final MauSacService mauSacService;

    public MauSacController(MauSacService mauSacService) {
        this.mauSacService = mauSacService;
    }

    @GetMapping
    public List<MauSac> getAllMauSac() {
        return mauSacService.getAllMauSac();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MauSac> getMauSacById(@PathVariable Integer id) {
        return mauSacService.getMauSacById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MauSac> createMauSac(@RequestBody MauSac mauSac) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mauSacService.createMauSac(mauSac));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MauSac> updateMauSac(@PathVariable Integer id, @RequestBody MauSac mauSac) {
        return ResponseEntity.ok(mauSacService.updateMauSac(id, mauSac));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMauSac(@PathVariable Integer id) {
        mauSacService.deleteMauSac(id);
        return ResponseEntity.noContent().build();
    }
}
