package com.example.demo.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {
    @GetMapping("/")
    public String home() {
        return "index"; // Tự động tìm index.html trong thư mục templates
    }
}
