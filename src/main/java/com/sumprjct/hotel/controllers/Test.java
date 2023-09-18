package com.sumprjct.hotel.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("")
    public String test(@NonNull HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }
}
