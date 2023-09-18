package com.sumprjct.hotel.controllers;


import com.sumprjct.hotel.service.ImageService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private final ImageService imageService;

    @GetMapping("/{id}")
    public void getImage(@PathVariable Long id, @NonNull HttpServletResponse response) throws IOException {
        imageService.getIconById(id, response);
    }

    @PutMapping()
    public List<Long> addImages(@RequestParam(value = "files") List<MultipartFile> files){
        return imageService.addImages(files);
    }
    
}
