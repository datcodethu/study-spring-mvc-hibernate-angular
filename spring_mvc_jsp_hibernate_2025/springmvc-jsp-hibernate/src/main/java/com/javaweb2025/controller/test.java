package com.javaweb2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
    @GetMapping("/")
    public String home() {
        return "index"; // Spring tìm /WEB-INF/views/index.jsp
    }
}
