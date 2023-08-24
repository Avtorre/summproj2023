package com.sumprjct.hotel.service;


import com.sumprjct.hotel.dao.ImageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    private final Path root = Paths.get("src/main/resources/static/images");

    @PostConstruct
    public void init(){
        try {
            Files.createDirectories(root);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

}
