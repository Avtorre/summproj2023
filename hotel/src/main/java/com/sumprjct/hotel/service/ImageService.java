package com.sumprjct.hotel.service;


import com.sumprjct.hotel.dao.ImageRepository;
import com.sumprjct.hotel.entities.Image;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    private final Path root = Paths.get("uploads");

    @PostConstruct
    public void init(){
        try {
            Files.createDirectories(root);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public void getIconById(Long id, @NonNull HttpServletResponse response) throws IOException {
        Image image = imageRepository.getImageById(id);
        if(image==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        java.io.File fileObject = new java.io.File(root.resolve(image.getPath()).toAbsolutePath().toString());
        response.setContentType(Files.probeContentType(fileObject.toPath()));
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + image.getName() + "\""));
        response.setContentLength((int) fileObject.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(fileObject));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    public String saveFile(MultipartFile file){
        String name = (new Date().toInstant()+".file").replaceAll(":", "-");
        try {
            Files.copy(file.getInputStream(), this.root.resolve(name));
        }catch (Exception e){
            if(e instanceof FileAlreadyExistsException)
                return saveFile(file);
        }
        return name;
    }

    public List<Long> addImages(List<MultipartFile> files) {
        List<Image> images = files.stream().map(file -> {
            String path = saveFile(file);
            return Image.builder()
                .name(file.getOriginalFilename())
                .path(path)
                .build();
        }).toList();
        return imageRepository.saveAll(images).stream().map(Image::getId).toList();
    }

}
