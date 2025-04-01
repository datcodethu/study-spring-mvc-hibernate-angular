package com.example.demo.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/")
    public String home() {
        return "index2"; // Tự động tìm index.html trong thư mục templates
    }

    @GetMapping("/admin/client")
    public String client() { return "views/admin/client/list"; }

}
